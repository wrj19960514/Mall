package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.wx.CommentVo;
import com.cskaoyan.mall.vo.wx.WxGoodsDetailVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WxGoodsServiceImpl implements WxGoodsService{

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    IssueMapper issueMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Override
    public long count() {
        GoodsExample goodsExample = new GoodsExample();
        return goodsMapper.countByExample(goodsExample);
    }

    @Override
    public List<Goods> getRelatedGoods(int id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id); // 根据商品id查到category id
        Integer categoryId = goods.getCategoryId();
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId); // 根据category id 查询类别下所有商品
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        Iterator<Goods> iterator = goodsList.iterator();
        while (iterator.hasNext()) { // 去除本商品
            Goods next = iterator.next();
            if (next.getId().equals(id)) {
                iterator.remove();
            }
        }
        return goodsList;
    }

    @Override
    public Map<String, Object> getCategory(int id) {
        Map<String, Object> map = new HashMap<>();
//        CategoryExample categoryExample = new CategoryExample();
//        CategoryExample.Criteria criteria = categoryExample.createCriteria();
//        criteria.andIdEqualTo(id);
//        Category currentCategory = (Category) categoryMapper.selectByExample(categoryExample);
        Category currentCategory = categoryMapper.selectByPrimaryKey(id);

        Integer pid = currentCategory.getPid();


//        CategoryExample categoryExample1 = new CategoryExample();
//        CategoryExample.Criteria criteria1 = categoryExample1.createCriteria();
//        criteria1.andIdEqualTo(id);
//        criteria1.andPidEqualTo(0);
        Category parentCategory = categoryMapper.selectByPrimaryKey(pid);

        CategoryExample categoryExample2 = new CategoryExample();
        CategoryExample.Criteria criteria2 = categoryExample2.createCriteria();
        criteria2.andPidEqualTo(pid);
        List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample2);

//        Integer pid = currentCategory.getPid();
//        CategoryExample categoryExample = new CategoryExample();
//        CategoryExample.Criteria criteria = categoryExample.createCriteria();
//        CategoryExample categoryExample1 = new CategoryExample();
//        CategoryExample.Criteria criteria1 = categoryExample1.createCriteria();
//        if (pid == 0) { // 一级种类 查找pid == 该类id的子类
//            criteria.andPidEqualTo(id);
//            List<Category> currentSubCategory = categoryMapper.selectByExample(categoryExample);
//            map.put("currentCategory", currentCategory);
//            map.put("currentSubCategory", currentSubCategory);
//        } else { // 二级种类
//            criteria.andIdEqualTo(pid); // 根据pid查找id == pid的父类
//            List<Category> parentCategory = categoryMapper.selectByExample(categoryExample);
//            criteria1.andPidEqualTo(pid);// 查找其他类pid==该pid的brother类
//            List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample1);
            map.put("brotherCategory", brotherCategory);
            map.put("currentCategory", currentCategory);
            map.put("parentCategory", parentCategory);
//        }
        return map;
    }

    @Override
    public GoodsByCategory getGoodsList(int categoryId, int page, int size) {
        // 根据categoryId 查找商品pid == 该id的商品
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        int count = goodsList.size();
        List<Category> filterCategoryList = null;
        return new GoodsByCategory(goodsList, count, filterCategoryList);
    }
    @Override
    public GoodsByCategory getGoodsListByBrand(Integer brandId, int page, int size) {
        // 根据brandId 查找
        PageHelper.startPage(page, size);
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andBrandIdEqualTo(brandId);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        int count = goodsList.size();
        List<Category> filterCategoryList = null;
        for (Goods goods : goodsList) {
            Category category = categoryMapper.selectByPrimaryKey(goods.getCategoryId());
            if (filterCategoryList == null) {
                filterCategoryList = new ArrayList<>();
            }
            filterCategoryList.add(category);
        }
        return new GoodsByCategory(goodsList, count, filterCategoryList);
    }

    @Override
    public WxGoodsDetailVo getGoodsDetail(int id) {
        WxGoodsDetailVo goodsDetailVo = new WxGoodsDetailVo();
        List<GoodsSpecification> specifications = goodsSpecificationMapper.selectSpecificationsByGoodsId(id);
        Set<String> set = new TreeSet<>();
        for (GoodsSpecification specification : specifications) {//商品规格的name
            set.add(specification.getSpecification());
        }
        List<SpecificationList> specificationLists = new ArrayList<>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            List<GoodsSpecification> newSpec = new ArrayList<>();
            for (GoodsSpecification specification : specifications) {
                if (name.equals(specification.getSpecification())) {
                    newSpec.add(specification);
                }
            }
            specificationLists.add(new SpecificationList(name, newSpec));
        }
        goodsDetailVo.setSpecificationList(specificationLists);
        List<GrouponRules> grouponRules = grouponRulesMapper.queryGrouponRuless(id);
        goodsDetailVo.setGroupon(grouponRules);
        List<Issue> issue = issueMapper.selectAllIssues();
        goodsDetailVo.setIssue(issue);
        goodsDetailVo.setUserHasCollect(false);
        //查找商品评论
        List<Comment> commentList = commentMapper.selectCommentByGoodsId(id);
        goodsDetailVo.setComment(new CommentVo(commentList, commentList.size()));
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        goodsDetailVo.setAttributes(goodsAttributeMapper.selectAttributesByGoodsId(id));
        goodsDetailVo.setBrand(brandMapper.selectByPrimaryKey(goods.getBrandId()));
        goodsDetailVo.setProductList(goodsProductMapper.selectProductsByGoodsId(id));
        goodsDetailVo.setInfo(goods);
        return goodsDetailVo;
    }


}
