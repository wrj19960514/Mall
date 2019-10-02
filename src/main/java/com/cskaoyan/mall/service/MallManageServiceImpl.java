package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.mapper.IssueMapper;
import com.cskaoyan.mall.mapper.KeywordMapper;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.CategoryVo;
import com.cskaoyan.mall.vo.mallManage.IssueListVo;
import com.cskaoyan.mall.vo.mallManage.KeywordListVo;
import com.cskaoyan.mall.vo.mallManage.OrderDetailedVo;
import com.cskaoyan.mall.vo.mallManage.OrderListVo;
import com.cskaoyan.mall.vo.mallManage.Question;
import com.cskaoyan.mall.vo.mallManage.RegionListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class MallManageServiceImpl implements MallManageService {
    @Autowired
    RegionMapper regionMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    KeywordMapper keywordMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List getRegionList(int i, int i2) {
        if (i > 700000) {
            return null;
        }
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(i, i2);
        List<Region> regions = regionMapper.selectByExample(example);
        ArrayList<RegionListVo> regionListVos = new ArrayList<>();
        for (Region region : regions) {
            Integer lowNum = region.getCode();
            RegionListVo vo = new RegionListVo();
            vo.setCode(region.getCode());
            vo.setId(region.getId());
            vo.setType(region.getType());
            vo.setName(region.getName());
            vo.setChildren(getRegionList(lowNum * 100, lowNum * 100 + 99));
            regionListVos.add(vo);
        }
        return regionListVos;
    }

    @Override
    public List getBrandList(BrandInfoVo brandInfoVo) {
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        if (brandInfoVo.getId() != 0) {
            criteria.andIdEqualTo(brandInfoVo.getId());
        }
        if (brandInfoVo.getName() != null) {
            criteria.andNameLike(brandInfoVo.getName());
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public void deleteBrand(Integer id, Boolean deleted) {
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Brand> brands = brandMapper.selectByExample(example);
        for (Brand brand : brands) {
            brand.setDeleted(true);
            brandMapper.updateByExample(brand, example);
        }
    }

    @Override
    public void createBrand(BrandCreateVo brandCreateVo) {
        Brand brand = new Brand();
        brand.setName(brandCreateVo.getName());
        brand.setDesc(brandCreateVo.getDesc());
        brand.setPicUrl(""); // TODO
        brand.setFloorPrice(brand.getFloorPrice());
        brand.setAddTime(new Date());
        brand.setDeleted(false);
        brandMapper.insert(brand);
    }

    @Override
    public List getOrderList(OrderListVo orderListVo) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (orderListVo.getOrderStatusArray() == 0) {
            ;
        } else {
            criteria.andOrderStatusEqualTo((short) orderListVo.getOrderStatusArray());
        }
        if (orderListVo.getUserId() == 0) {
            ;
        } else {
            criteria.andUserIdEqualTo((int) orderListVo.getUserId());
        }
        if (orderListVo.getOrderSn() == null || orderListVo.getOrderSn().equals("")) {
            orderListVo.setOrderSn("%%");
        } else {
            String sn = orderListVo.getOrderSn();
            orderListVo.setOrderSn("%" + sn + "%");
        }
        criteria.andOrderSnLike(orderListVo.getOrderSn());
        List<Order> orders = orderMapper.selectByExample(orderExample);
        return orders;
    }

    @Override
    public OrderDetailedVo getOrderDetailed(int id) {
        OrderDetailedVo orderDetailedVo = new OrderDetailedVo();
        Order order = orderMapper.selectByPrimaryKey(id);
        orderDetailedVo.setOrder(order);
        OrderGoods orderGoods = orderGoodsMapper.selectByPrimaryKey(id);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(orderGoods);
        orderDetailedVo.setOrderGoods(objects);
        User user = new User();
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        user.setNickname("Username1");
        orderDetailedVo.setUser(user);
        return orderDetailedVo;
    }

    @Override
    public List getIssueList(IssueListVo issueListVo) {
        IssueExample example = new IssueExample();
        IssueExample.Criteria criteria = example.createCriteria();
        if (issueListVo.getQuestion() == null) {
            issueListVo.setQuestion("%%");
        } else {
            String s = issueListVo.getQuestion();
            issueListVo.setQuestion("%" + s + "%");
        }
        criteria.andQuestionLike(issueListVo.getQuestion());
        List<Issue> issues = issueMapper.selectByExample(example);
        return issues;
    }

    @Override
    public void createissue(Question question) {
        Issue issue = new Issue();
        issue.setDeleted(false);
        issue.setQuestion(question.getQuestion());
        issue.setAddTime(new Date());
        issue.setAnswer(question.getAnswer());
        issueMapper.insert(issue);
    }

    @Override
    public void deleteIssue(Issue issue) {
        issue.setDeleted(true);
        IssueExample issueExample = new IssueExample();
        issueExample.createCriteria().andIdEqualTo(issue.getId());
        issueMapper.updateByExample(issue, issueExample);
    }

    @Override
    public void updateIssue(Issue issue) {
        IssueExample issueExample = new IssueExample();
        issueExample.createCriteria().andIdEqualTo(issue.getId());
        issueMapper.updateByExample(issue, issueExample);
    }

    @Override
    public List getKeywordList(KeywordListVo keywordListVo) {
        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        if (keywordListVo.getKeyword() == null) {
            keywordListVo.setKeyword("%%");
        } else {
            String s = keywordListVo.getKeyword();
            keywordListVo.setKeyword("%" + s + "%");
        }
        if (keywordListVo.getUrl() == null) {
            keywordListVo.setUrl("%%");
        } else {
            String s = keywordListVo.getUrl();
            keywordListVo.setUrl("%" + s + "%");
        }
        criteria.andUrlLike(keywordListVo.getUrl());
        criteria.andKeywordLike(keywordListVo.getKeyword());
        List<Keyword> keywords = keywordMapper.selectByExample(keywordExample);
        return keywords;
    }

    @Override
    public void createKeyword(Keyword keyword) {
        keyword.setSortOrder(100);
        keyword.setAddTime(new Date());
        keyword.setDeleted(false);
        keywordMapper.insert(keyword);
    }

    @Override
    public void updateKeyword(Keyword keyword) {
        KeywordExample keywordExample = new KeywordExample();
        keywordExample.createCriteria().andIdEqualTo(keyword.getId());
        keyword.setUpdateTime(new Date());
        keywordMapper.updateByExample(keyword, keywordExample);
    }

    @Override
    public void deleteKeyword(Keyword keyword) {
        keyword.setDeleted(true);
        KeywordExample keywordExample = new KeywordExample();
        keywordExample.createCriteria().andIdEqualTo(keyword.getId());
        keywordMapper.updateByExample(keyword, keywordExample);
    }

    @Override
    public List getCategoryL1() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andPidEqualTo(0);
        criteria.andDeletedEqualTo(false);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        ArrayList objects = new ArrayList();
        for (Category category : categories) {
            HashMap map = new HashMap();
            map.put("label", category.getName());
            map.put("value", category.getId());
            objects.add(map);
        }
        return objects;
    }

    @Override
    public List getCategoryListAndChildren() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andPidEqualTo(0);
        criteria.andDeletedEqualTo(false);
        List<Category> l1 = categoryMapper.selectByExample(categoryExample);
        ArrayList list = new ArrayList();
        for (Category category : l1) {
            HashMap map = new HashMap();
            map.put("desc", category.getDesc());
            map.put("iconUrl", category.getIconUrl());
            map.put("id", category.getId());
            map.put("keywords", category.getKeywords());
            map.put("level", category.getLevel());
            map.put("name", category.getName());
            map.put("picUrl", category.getPicUrl());
            List children = getListChildren(category.getId());
            map.put("children", children);
            list.add(map);
        }
        return list;
    }

    @Override
    public void createCategory(CategoryVo categoryVo) {
        Category category = new Category();
        category.setAddTime(new Date());
        category.setDeleted(false);
        if (categoryVo.getIconUrl() == null) {
            categoryVo.setIconUrl("");
        }
        if (categoryVo.getPicUrl() == null) {
            categoryVo.setPicUrl("");
        }
        category.setIconUrl(categoryVo.getIconUrl());
        category.setPicUrl(categoryVo.getPicUrl());
        category.setKeywords(categoryVo.getKeywords());
        category.setDesc(categoryVo.getDesc());
        category.setName(categoryVo.getName());
        category.setLevel(categoryVo.getLevel());
        category.setPid(categoryVo.getPid());
        category.setSortOrder((byte) 5);
        int insert = categoryMapper.insert(category);
        System.out.println("insert = " + insert);
    }

    @Override
    public void deleteCategory(CategoryVo categoryVo) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andIdEqualTo(categoryVo.getId());
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        for (Category category : categories) {
            category.setDeleted(true);
            categoryMapper.updateByExample(category, categoryExample);
        }
    }

    @Override
    public void updateCategory(CategoryVo categoryVo) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andIdEqualTo(categoryVo.getId());
        Category category = new Category();
        category.setAddTime(new Date());
        category.setDeleted(false);
        if (categoryVo.getIconUrl() == null) {
            categoryVo.setIconUrl("");
        }
        if (categoryVo.getPicUrl() == null) {
            categoryVo.setPicUrl("");
        }
        category.setIconUrl(categoryVo.getIconUrl());
        category.setPicUrl(categoryVo.getPicUrl());
        category.setKeywords(categoryVo.getKeywords());
        category.setDesc(categoryVo.getDesc());
        category.setName(categoryVo.getName());
        category.setLevel(categoryVo.getLevel());
        category.setPid(categoryVo.getPid());
        category.setSortOrder((byte) 5);
        category.setUpdateTime(new Date());
        category.setId(categoryVo.getId());
        categoryMapper.updateByExample(category, categoryExample);
    }

    private List getListChildren(Integer id) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andPidEqualTo(id);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        ArrayList list = new ArrayList();
        for (Category category : categories) {
            HashMap map = new HashMap();
            map.put("desc", category.getDesc());
            map.put("iconUrl", category.getIconUrl());
            map.put("id", category.getId());
            map.put("keywords", category.getKeywords());
            map.put("level", category.getLevel());
            map.put("name", category.getName());
            map.put("picUrl", category.getPicUrl());
            list.add(map);
        }
        return list;
    }
}
