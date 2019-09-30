package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.mapper.IssueMapper;
import com.cskaoyan.mall.mapper.KeywordMapper;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.IssueListVo;
import com.cskaoyan.mall.vo.mallManage.KeywordListVo;
import com.cskaoyan.mall.vo.mallManage.OrderDetailedVo;
import com.cskaoyan.mall.vo.mallManage.OrderListVo;
import com.cskaoyan.mall.vo.mallManage.Question;
import com.cskaoyan.mall.vo.mallManage.RegionListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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
        if (orderListVo.getUserId() != 0) {
            criteria.andUserIdEqualTo((int) orderListVo.getUserId());
        }
        if ("".equals(orderListVo.getOrderSn())) {
            BaseRespVo.error(null);
        }
        if (orderListVo.getOrderSn() != null) {
            criteria.andOrderSnEqualTo(orderListVo.getOrderSn());
        }
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
        keywordMapper.updateByExample(keyword,keywordExample);
    }
}
