package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.util.ParamUtils;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.goodsManage.CategoryList;
import com.cskaoyan.mall.vo.goodsManage.GoodsVo;
import com.cskaoyan.mall.vo.goodsManage.Label;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        goodsExample.setOrderByClause(sort + " " + order);
        // 商品id精确查询,商品名称模糊查询
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (!ParamUtils.isEmpty(goodsSn)) {
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if (!ParamUtils.isEmpty(name)) {
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean delete(Goods goods) {
        Integer id = goods.getId();
        // 删除商品表中的数据
        goodsMapper.deleteByPrimaryKey(id);
        // 删除有关该商品的其他表中参数
        // goods_attribute
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andGoodsIdEqualTo(id);
        goodsAttributeMapper.deleteByExample(goodsAttributeExample);
        // goods_product
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        goodsProductExample.createCriteria().andGoodsIdEqualTo(id);
        goodsProductMapper.deleteByExample(goodsProductExample);
        // goods_specification
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        goodsSpecificationExample.createCriteria().andGoodsIdEqualTo(id);
        goodsSpecificationMapper.deleteByExample(goodsSpecificationExample);
        return true;
    }

    @Override
    public ListBean commentList(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page, limit);
        CommentExample commentExample = new CommentExample();
        // 根据sort的字段,升序或降序排列
        commentExample.setOrderByClause(sort + " " + order);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        // 用户id精确查询
        if (!ParamUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        // 商品id精准查询
        if (!ParamUtils.isEmpty(valueId)) {
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public BaseRespVo create(GoodsVo goodsVo) {
        // 存入数据
        Date date = new Date();
        Goods goods = goodsVo.getGoods();
        // 0 添加商品 , 1 是更新商品
        BaseRespVo baseRespVo = checkGoodsData(goods, 0);
        if (baseRespVo.getErrno() == 400) {
            return baseRespVo;
        }
        goods.setAddTime(date);
        goods.setUpdateTime(date);
        // 插入商品, 通过select key获取商品id
        goodsMapper.insert(goods);
        Integer id = goods.getId();
        // 插入商品参数表数据
        List<GoodsAttribute> attributes = goodsVo.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(id);
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            goodsAttributeMapper.insert(attribute);
        }
        // 插入商品货品表数据
        List<GoodsProduct> products = goodsVo.getProducts();
        for (GoodsProduct product : products) {
            product.setGoodsId(id);
            product.setAddTime(date);
            product.setUpdateTime(date);
            goodsProductMapper.insert(product);
        }
        // 插入商品规格表数据
        List<GoodsSpecification> specifications = goodsVo.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(id);
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            goodsSpecificationMapper.insert(specification);
        }
        return BaseRespVo.ok(null);
    }

    private BaseRespVo checkGoodsData(Goods goods, int i) {
        BaseRespVo baseRespVo = new BaseRespVo();
        if (goodsMapper.checkGoodsData(goods.getGoodsSn(), goods.getName()) > i) {
            baseRespVo.setErrmsg("商品名称/编号已存在");
            baseRespVo.setErrno(400);
            return baseRespVo;
        }
        String unit = goods.getUnit();
        if (unit != null && !"件".equals(unit) && !"个".equals(unit) && !"盒".equals(unit)) {
            baseRespVo.setErrmsg("商品单位必须是:件/个/盒");
            baseRespVo.setErrno(400);
            return baseRespVo;
        }
        return baseRespVo;
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
        // 商品所属分类id 和 父id
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public BaseRespVo update(GoodsVo goodsVo) {
        // goods
        Date date = new Date();
        Goods goods = goodsVo.getGoods();
        // 0 添加商品 , 1 是更新商品
        BaseRespVo baseRespVo = checkGoodsData(goods, 1);
        if (baseRespVo.getErrno() == 400) {
            return baseRespVo;
        }
        goods.setUpdateTime(date);
        goodsMapper.updateByPrimaryKey(goods);
        // attributes
        List<GoodsAttribute> attributes = goodsVo.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setUpdateTime(date);
            goodsAttributeMapper.updateByPrimaryKey(attribute);
        }
        // products
        List<GoodsProduct> products = goodsVo.getProducts();
        for (GoodsProduct product : products) {
            product.setUpdateTime(date);
            goodsProductMapper.updateByPrimaryKey(product);
        }
        // specifications
        List<GoodsSpecification> specifications = goodsVo.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setUpdateTime(date);
            goodsSpecificationMapper.updateByPrimaryKey(specification);
        }
        return BaseRespVo.ok(null);
    }
}
