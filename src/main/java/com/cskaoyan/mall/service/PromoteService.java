package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.ListBean;

public interface PromoteService {
    /**
     * 广告管理:获取广告
     * @param page  页面数
     * @param limit  每页显示的条数
     * @param sort  根据sort排序
     * @param order   排序的的顺序 升序/降序
     * @param name   广告的标题
     * @param content 广告的内容
     * @return  返回的广告信息
     */
    ListBean getAdList(int page, int limit, String sort, String order, String name, String content);
    //添加
    Ad createAds(Ad ad);
    //编辑
    Ad updateAds(Ad ad);
    //删除
    void deleteAds(Ad ad);
    /*-----------------------------优惠券管理------------------------------------*/
    /**
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @param name
     * @param type
     * @param status
     * @return 返回优惠券信息
     */
    ListBean getCouponList(int page, int limit, String sort, String order, String name, String type, String status);
    //添加
    Coupon insertCoupon(Coupon coupon);
    //详情中获取信息
    Coupon readCoupon(int id);
    //详情中的查找
    ListBean getLIstUser(int page, int limit, String sort, String order, String couponId, String userId, String status);
    //编辑
    Coupon updateCoupon(Coupon coupon);
    //删除
    void deleteCoupon(Coupon coupon);
    /*-----------------------------专题管理---------------------------------------*/
    //获取页面信息
    ListBean getTopicList(int page, int limit, String sort, String order, String title, String subtitle);

    //添加专题
    Topic createTopic(Topic topic);

    //编辑专题
    Topic updateTopic(Topic topic);

    //删除专题
    void deleteTopic(Topic topic);
    /*-------------------------------团购规则--------------------------------------*/
    //获取页面信息
    ListBean getGrouponRulesList(int page, int limit, String goodsId, String sort, String order);

    //添加团购规则
    GrouponRules createGrouponRules(GrouponRules grouponRules);

    //编辑团购规则
    void updateGrouponRules(GrouponRules grouponRules);

    //删除团购规则
    void deleteGrouponRules(GrouponRules grouponRules);
    /*-------------------------------------团购活动---------------------------------------*/
    //获取页面信息
    ListBean getListRecord(int page, int limit, String sort, String order, String goodsId);
}
