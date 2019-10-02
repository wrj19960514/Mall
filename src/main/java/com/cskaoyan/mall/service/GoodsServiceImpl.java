package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.goodsManage.CategoryList;
import com.cskaoyan.mall.vo.goodsManage.GoodsVo;
import com.cskaoyan.mall.vo.goodsManage.Label;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 14:41
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;
    @Override
    public ListBean getGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        // 根据sort的字段,升序或降序排列
        goodsExample.setOrderByClause(sort+ " " + order);
        // 商品id精确查询,商品名称模糊查询
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (goodsSn != null && !("".equals(goodsSn.trim()))) {
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if (name != null && !("".equals(name.trim()))) {
            criteria.andNameLike("%" + name + "%");
        }
        List<Goods> goods = goodsMapper.selectByExampleWithBLOBs(goodsExample);
        PageInfo<Goods> userPageInfo = new PageInfo<>(goods);
        long total = userPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(goods);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public CatAndBrand catAndBrand() {
        List<CategoryList> categoryList = categoryMapper.queryCategoryLabel();
        for (CategoryList categories : categoryList) {
            Integer id = categories.getValue();
            List<Label> children = categoryMapper.queryCategoryChildren(id);
            categories.setChildren(children);
        }
        List<Label> brands = brandMapper.queryBrandLabel();
        CatAndBrand catAndBrand = new CatAndBrand();
        catAndBrand.setBrandList(brands);
        catAndBrand.setCategoryList(categoryList);
        return catAndBrand;
    }

    @Override
    public boolean delete(Goods goods) {
        int i = goodsMapper.deleteByPrimaryKey(goods.getId());
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public ListBean commentList(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page, limit);
        CommentExample commentExample = new CommentExample();
        // 根据sort的字段,升序或降序排列
        commentExample.setOrderByClause(sort+ " " + order);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        // 用户id精确查询
        if (userId != null && !("".equals(userId.trim())) ) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        // 商品id精准查询
        if (valueId != null && !("".equals(valueId.trim()))) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId));
        }
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> userPageInfo = new PageInfo<>(comments);
        long total = userPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(comments);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        int i = commentMapper.deleteByPrimaryKey(comment.getId());
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean create(GoodsVo goodsVo) {
        Date date = new Date();
        // 插入商品, 通过selectkey获取商品id
        goodsVo.getGoods().setAddTime(date);
        goodsVo.getGoods().setUpdateTime(date);
        Goods goods = goodsVo.getGoods();
        goodsMapper.insert(goods);
        Integer id = goods.getId();
        // 插入商品参数
        List<GoodsAttribute> attributes = goodsVo.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(id);
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            int insert = goodsAttributeMapper.insert(attribute);
        }
        // 插入商品货品表
        List<GoodsProduct> products = goodsVo.getProducts();
        for (GoodsProduct product : products) {
            product.setGoodsId(id);
            product.setAddTime(date);
            product.setUpdateTime(date);
            int insert = goodsProductMapper.insert(product);
        }
        // 插入商品规格表
        List<GoodsSpecification> specifications = goodsVo.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(id);
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            int insert = goodsSpecificationMapper.insert(specification);
        }
        return true;
    }

    @Override
    public GoodsVo detail(int id) {
        GoodsVo goodsVo = new GoodsVo();
        // 商品信息
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        // 商品参数
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsAttribute> goodsAttributes = goodsAttributeMapper.selectByExample(goodsAttributeExample);
        // 商品货品
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        goodsProductExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(goodsProductExample);
        // 商品规格
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        goodsSpecificationExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsSpecification> goodsSpecifications = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
        // categoryIds
        Integer categoryId = goods.getCategoryId();
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        Integer pid = category.getPid();
        goodsVo.setGoods(goods);
        goodsVo.setAttributes(goodsAttributes);
        goodsVo.setProducts(goodsProducts);
        goodsVo.setSpecifications(goodsSpecifications);
        goodsVo.setCategoryIds(new Integer[]{pid, categoryId});
        return goodsVo;
    }
}
