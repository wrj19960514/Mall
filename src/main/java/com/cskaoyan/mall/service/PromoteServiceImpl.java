package com.cskaoyan.mall.service;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.promote.GrouponsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PromoteServiceImpl implements PromoteService {

    @Autowired
    AdMapper adMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GrouponMapper grouponMapper;

    private ListBean listBean;


    @Override
    public ListBean getAdList(int page, int limit, String sort, String order, String name, String content) {
        PageHelper.startPage(page, limit);
        AdExample adExample = new AdExample();
        //根据sort的字段来升序或者降序排列
        adExample.setOrderByClause(sort + " " + order);
        //当标题与内容都不是空是全部查询 example 是用来加条件 如果不加查询全部的haul不加条件就可以了
        //根据广告内容或者广告标题进行模糊查询
        AdExample.Criteria criteria = adExample.createCriteria();
        if (!StringUtils.isEmpty(name)) {

            criteria.andContentLike("%" + name + "%");
        }

        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }

        List<Ad> ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> adPageInfo = new PageInfo<>(ads);
        long total = adPageInfo.getTotal();
        //返回的数据
        ListBean listBean = new ListBean();
        listBean.setItems(ads);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public Ad createAds(Ad ad) {
        AdExample adExample = new AdExample();
        int insert = adMapper.insert(ad);
        Integer id = ad.getId();
        ad = adMapper.selectByPrimaryKey(id);
        return ad;
    }

    @Override
    public Ad updateAds(Ad ad) {
        AdExample adExample = new AdExample();
        adExample.createCriteria().andIdEqualTo(ad.getId());
        int i = adMapper.updateByExample(ad, adExample);
        ad = adMapper.selectByPrimaryKey(ad.getId());
        return ad;
    }

    @Override
    public void deleteAds(Ad ad) {
        AdExample adExample = new AdExample();
        adExample.createCriteria().andIdEqualTo(ad.getId());
        int i = adMapper.deleteByPrimaryKey(ad.getId());
    }

    /*-------------------------------优惠券管理-----------------------*/
    @Override
    public ListBean getCouponList(int page, int limit, String sort, String order, String name, String type, String status) {
        PageHelper.startPage(page, limit);
        CouponExample couponExample = new CouponExample();
        //排序
        couponExample.setOrderByClause(sort + " " + order);
        //查询
        CouponExample.Criteria criteria = couponExample.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtil.isEmpty(type)) {
            criteria.andTypeEqualTo(Short.valueOf(type));
        }
        if (!StringUtil.isEmpty(status)) {
            criteria.andStatusEqualTo(Short.valueOf(status));
        }
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        //返回的数据
        ListBean listBean = new ListBean();
        listBean.setItems(coupons);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public Coupon insertCoupon(Coupon coupon) {
        CouponExample couponExample = new CouponExample();
        int insert = couponMapper.insert(coupon);
        Integer id = coupon.getId();
        coupon = couponMapper.selectByPrimaryKey(id);
        return coupon;
    }

    @Override
    public Coupon readCoupon(int id) {
        CouponUserExample couponUserExample = new CouponUserExample();
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        return coupon;
    }

    @Override
    public ListBean getLIstUser(int page, int limit, String sort, String order, String couponId, String userId, String status) {
        PageHelper.startPage(page, limit);
        CouponUserExample couponUserExample = new CouponUserExample();
        couponUserExample.setOrderByClause(sort + " " + order);
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
        if (!StringUtil.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtil.isEmpty(status)) {
            criteria.andStatusEqualTo(Short.valueOf(status));
        }
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
        PageInfo<CouponUser> couponUserPageInfo = new PageInfo<>(couponUsers);
        long total = couponUserPageInfo.getTotal();
        //返回数据
        ListBean listBean = new ListBean();
        listBean.setItems(couponUsers);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        CouponExample couponExample = new CouponExample();
        int i = couponMapper.updateByPrimaryKey(coupon);
        coupon = couponMapper.selectByPrimaryKey(coupon.getId());
        return coupon;
    }

    @Override
    public void deleteCoupon(Coupon coupon) {
        CouponExample couponExample = new CouponExample();
        int i = couponMapper.deleteByPrimaryKey(coupon.getId());
    }

    /*-------------------------------------------专题管理---------------------------------------*/
    @Override
    public ListBean getTopicList(int page, int limit, String sort, String order, String title, String subtitle) {
        TopicExample topicExample = new TopicExample();
        //分页
        PageHelper.startPage(page, limit);
        topicExample.setOrderByClause(sort + " " + order);
        //模糊查询
        TopicExample.Criteria criteria = topicExample.createCriteria();
        if (!StringUtil.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtil.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        //获取total
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        long total = topicPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(topics);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public Topic createTopic(Topic topic) {
        TopicExample topicExample = new TopicExample();
        int insert = topicMapper.insert(topic);
        Integer id = topic.getId();
        topic = topicMapper.selectByPrimaryKey(id);
        return topic;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        TopicExample topicExample = new TopicExample();
        int i = topicMapper.updateByPrimaryKey(topic);
        topic = topicMapper.selectByPrimaryKey(topic.getId());
        return topic;
    }

    @Override
    public void deleteTopic(Topic topic) {
        TopicExample topicExample = new TopicExample();
        int i = topicMapper.deleteByPrimaryKey(topic.getId());
    }

    /*---------------------------------------团购规则---------------------------------------*/
    @Override
    public ListBean getGrouponRulesList(int page, int limit, String goodsId, String sort, String order) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        //分页
        PageHelper.startPage(page, limit);
        grouponRulesExample.setOrderByClause(sort + " " + order);
        GrouponRulesExample.Criteria criteria = grouponRulesExample.createCriteria();
        //查询
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        //获取total
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(grouponRules);
        long total = grouponRulesPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(grouponRules);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public GrouponRules createGrouponRules(GrouponRules grouponRules) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        Goods goods = goodsMapper.selectByPrimaryKey(Integer.valueOf(grouponRules.getGoodsId()));
        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());
        Date date = new Date();
        grouponRules.setAddTime(date);
        grouponRules.setUpdateTime(date);
        int insert = grouponRulesMapper.insert(grouponRules);
        Integer id = grouponRules.getId();
        grouponRules = grouponRulesMapper.selectByPrimaryKey(id);
        return grouponRules;
    }

    @Override
    public void updateGrouponRules(GrouponRules grouponRules) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        int i = grouponRulesMapper.updateByPrimaryKey(grouponRules);
    }

    @Override
    public void deleteGrouponRules(GrouponRules grouponRules) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
    }
    /*--------------------------------------团购活动---------------------------------------*/
    @Override
    public ListBean getListRecord(int page, int limit, String sort, String order, String goodsId) {
        GrouponExample grouponExample = new GrouponExample();
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        //分页
        PageHelper.startPage(page, limit);
        grouponExample.setOrderByClause(sort + " " + order);
        GrouponsVo grouponsVo = new GrouponsVo();
        GrouponExample.Criteria grouponExampleCriteria = grouponExample.createCriteria();
        GrouponRulesExample.Criteria grouponRulesExampleCriteria = grouponRulesExample.createCriteria();
        ArrayList itemsList = new ArrayList<GrouponsVo>();
        if (!StringUtil.isEmpty(goodsId)) {
            grouponRulesExampleCriteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
            List<GrouponRules> grouponRules1 = grouponRulesMapper.selectByExample(grouponRulesExample);
            for (GrouponRules grouponRule : grouponRules1) {
                Integer id = grouponRule.getId();
                grouponExampleCriteria.andRulesIdEqualTo(id);
                List<Groupon>  groupons = grouponMapper.selectByExample(grouponExample);
                for (Groupon groupon : groupons) {
                    grouponsVo.setGroupon(groupon);
                    Integer rulesId = groupon.getRulesId();
                    GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(rulesId);
                    grouponsVo.setRules(grouponRules);
                    Goods goods = goodsMapper.selectByPrimaryKey(Integer.valueOf(grouponRules.getGoodsId()));
                    grouponsVo.setGoods(goods);
                    itemsList.add(grouponsVo);
                }

            }
        } else {
            List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
            for (Groupon groupon : groupons) {
                grouponsVo.setGroupon(groupon);
                Integer rulesId = groupon.getRulesId();
                GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(rulesId);
                grouponsVo.setRules(grouponRules);
                Goods goods = goodsMapper.selectByPrimaryKey(Integer.valueOf(grouponRules.getGoodsId()));
                grouponsVo.setGoods(goods);
                itemsList.add(grouponsVo);
            }
        }


        //获取total
        PageInfo<Groupon> grouponPageInfo = new PageInfo<>();
        long total = grouponPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(itemsList);
        listBean.setTotal(total);
        return listBean;
    }


}
