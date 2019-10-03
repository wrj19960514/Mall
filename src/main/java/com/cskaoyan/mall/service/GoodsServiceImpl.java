package com.cskaoyan.mall.service;

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

import java.math.BigDecimal;
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
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
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
        // 删除goods
        goodsMapper.deleteByPrimaryKey(id);
        // 删除有关该商品的其他参数
        // attribute
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andGoodsIdEqualTo(id);
        goodsAttributeMapper.deleteByExample(goodsAttributeExample);
        // product
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        goodsProductExample.createCriteria().andGoodsIdEqualTo(id);
        goodsProductMapper.deleteByExample(goodsProductExample);
        // specification
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

        Goods goods = goodsVo.getGoods();
        List<GoodsAttribute> attributes = goodsVo.getAttributes();
        List<GoodsProduct> products = goodsVo.getProducts();
        List<GoodsSpecification> specifications = goodsVo.getSpecifications();
        // 数据校验
        BaseRespVo baseRespVo = checkData(goods, attributes, products, specifications, 0);
        if (baseRespVo.getErrno() == 401) {
            return baseRespVo;
        }
        // 存入数据
        Date date = new Date();
        goods.setAddTime(date);
        goods.setUpdateTime(date);
        // 插入商品, 通过select key获取商品id
        goodsMapper.insert(goods);
        Integer id = goods.getId();
        // 插入商品参数
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(id);
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            int insert = goodsAttributeMapper.insert(attribute);
        }
        // 插入商品货品表
        for (GoodsProduct product : products) {
            product.setGoodsId(id);
            product.setAddTime(date);
            product.setUpdateTime(date);
            int insert = goodsProductMapper.insert(product);
        }
        // 插入商品规格表
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(id);
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            int insert = goodsSpecificationMapper.insert(specification);
        }
        return BaseRespVo.ok(null);
    }

    private BaseRespVo checkData(Goods goods, List<GoodsAttribute> attributes, List<GoodsProduct> products, List<GoodsSpecification> specifications, int method) {
        BaseRespVo checkGoodsData = checkGoodsData(goods, method);
        if (checkGoodsData.getErrno() == 401) {
            return checkGoodsData;
        }
        BaseRespVo checkAttribute = checkAttribute(attributes);
        if (checkAttribute.getErrno() == 401) {
            return checkAttribute;
        }
        BaseRespVo checkProduct = checkProduct(products);
        if (checkProduct.getErrno() == 401) {
            return checkProduct;
        }
        BaseRespVo checkSpecification = checkSpecification(specifications);
        if (checkSpecification.getErrno() == 401) {
            return checkSpecification;
        }
        return BaseRespVo.ok(null);
    }

    private BaseRespVo checkSpecification(List<GoodsSpecification> specifications) {
        BaseRespVo baseRespVo = new BaseRespVo();
        for (GoodsSpecification specification : specifications) {
            if (ParamUtils.isEmpty(specification.getSpecification()) || ParamUtils.isEmpty(specification.getValue())) {
                baseRespVo.setErrmsg("规格不为空");
                baseRespVo.setErrno(401);
                return baseRespVo;
            }
        }
        return baseRespVo;
    }

    private BaseRespVo checkProduct(List<GoodsProduct> products) {
        BaseRespVo baseRespVo = new BaseRespVo();
        for (GoodsProduct product : products) {
            if (product.getNumber() == null || !ParamUtils.isInteger(product.getNumber().toString()) ||
                    product.getPrice() == null || !ParamUtils.isInteger(product.getPrice().toString()) ||
                    product.getNumber() < 0 || product.getPrice().compareTo(new BigDecimal("0")) == -1) {
                baseRespVo.setErrmsg("库存输入正确数值");
                baseRespVo.setErrno(401);
                return baseRespVo;
            }
        }
        return baseRespVo;
    }

    private BaseRespVo checkAttribute(List<GoodsAttribute> attributes) {
        BaseRespVo baseRespVo = new BaseRespVo();
        for (GoodsAttribute attribute : attributes) {
            if (ParamUtils.isEmpty(attribute.getAttribute()) || ParamUtils.isEmpty(attribute.getValue())) {
                baseRespVo.setErrmsg("商品参数不为空");
                baseRespVo.setErrno(401);
                return baseRespVo;
            }
        }
        return baseRespVo;
    }

    private BaseRespVo checkGoodsData(Goods goods, int method) {
        BaseRespVo baseRespVo = new BaseRespVo();
        String goodsSn = goods.getGoodsSn();
        String name = goods.getName();
        // 商品编号不为空, 必须为数字, 数据库中不重复
        // 商品名称不为空, 数据库中不重复
        if (method == 0) {
            if (ParamUtils.isEmpty(goodsSn) || !ParamUtils.isInteger(goodsSn) || ParamUtils.isEmpty(name) ||
                    goodsMapper.checkGoodsData(goodsSn, name) >= 1) {
                baseRespVo.setErrmsg("商品编号/名称: 不正确/已存在");
                baseRespVo.setErrno(401);
                return baseRespVo;
            }
        }
        if (method == 1) {
            if (ParamUtils.isEmpty(goodsSn) || !ParamUtils.isInteger(goodsSn) || ParamUtils.isEmpty(name) ||
                    goodsMapper.checkGoodsData(goodsSn, name) > 1) {
                baseRespVo.setErrmsg("商品编号/名称: 不正确/已存在");
                baseRespVo.setErrno(401);
                return baseRespVo;
            }
        }
        // 专柜价格 当前价格
        BigDecimal counterPrice = goods.getCounterPrice();
        BigDecimal retailPrice = goods.getRetailPrice();
        if (counterPrice == null || !ParamUtils.isInteger(counterPrice.toString()) ||
                retailPrice == null || !ParamUtils.isInteger(retailPrice.toString()) ||
                counterPrice.compareTo(new BigDecimal("0")) == -1 || retailPrice.compareTo(new BigDecimal("0")) == -1) {
            baseRespVo.setErrmsg("价格输入不正确");
            baseRespVo.setErrno(401);
            return baseRespVo;
        }
        if (goods.getIsHot() == null || goods.getIsNew() == null || goods.getIsOnSale() == null) {
            baseRespVo.setErrmsg("选择:新品/热卖/在售");
            baseRespVo.setErrno(401);
            return baseRespVo;
        }
        String unit = goods.getUnit();
        if (ParamUtils.isEmpty(goods.getPicUrl()) || goods.getCategoryId() == null ||
                goods.getBrandId() == null || ParamUtils.isEmpty(unit)) {
            baseRespVo.setErrmsg("请输入商品基本信息");
            baseRespVo.setErrno(401);
            return baseRespVo;
        }
        if (!"件".equals(unit.trim()) && !"个".equals(unit.trim()) && !"盒".equals(unit.trim())) {
            baseRespVo.setErrmsg("商品单位:件/个/盒");
            baseRespVo.setErrno(401);
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public BaseRespVo update(GoodsVo goodsVo) {
        Goods goods = goodsVo.getGoods();
        List<GoodsAttribute> attributes = goodsVo.getAttributes();
        List<GoodsProduct> products = goodsVo.getProducts();
        List<GoodsSpecification> specifications = goodsVo.getSpecifications();
        // 数据校验
        BaseRespVo baseRespVo = checkData(goods, attributes, products, specifications, 1);
        if (baseRespVo.getErrno() == 401) {
            return baseRespVo;
        }
        // goods
        Date date = new Date();
        goods.setUpdateTime(date);
        goodsMapper.updateByPrimaryKey(goods);
        // attributes
        for (GoodsAttribute attribute : attributes) {
            attribute.setUpdateTime(date);
            goodsAttributeMapper.updateByPrimaryKey(attribute);
        }
        // products
        for (GoodsProduct product : products) {
            product.setUpdateTime(date);
            goodsProductMapper.updateByPrimaryKey(product);
        }
        // specifications
        for (GoodsSpecification specification : specifications) {
            specification.setUpdateTime(date);
            goodsSpecificationMapper.updateByPrimaryKey(specification);
        }
        return BaseRespVo.ok(null);
    }
}
