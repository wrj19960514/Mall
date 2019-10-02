package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.service.PromoteService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoteController {

    @Autowired
    PromoteService promoteService;

    /*-----------------------------------广告管理---------------------------------------------*/
    //获取广告信息,模糊查询
    @RequestMapping("/admin/ad/list")
    public BaseRespVo getAdList(int page, int limit, String sort, String order, String name, String content) {
        ListBean adList = promoteService.getAdList(page, limit, sort, order, name, content);
        BaseRespVo ok = BaseRespVo.ok(adList);
        return ok;
    }
    //编辑广告信息
    @RequestMapping("/admin/ad/update")
    public BaseRespVo updateAds(@RequestBody Ad ad) {
        ad = promoteService.updateAds(ad);
        BaseRespVo ok = BaseRespVo.ok(ad);
        return ok;
    }
    //删除
    @RequestMapping("/admin/ad/delete")
    public BaseRespVo deleteAds(@RequestBody Ad ad) {
        promoteService.deleteAds(ad);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(null);
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }


    /*-----------------------------优惠券管理---------------------------------------*/
    //获取优惠券信息
    @RequestMapping("/admin/coupon/list")
    public BaseRespVo getCouponList(int page, int limit, String sort, String order, String name, String type, String status) {
        ListBean couponList = promoteService.getCouponList(page, limit, sort, order, name, type, status);
        BaseRespVo ok = BaseRespVo.ok(couponList);
        return ok;
    }
    //添加优惠券信息
    @RequestMapping("/admin/coupon/create")
    public BaseRespVo insertCoupon(@RequestBody Coupon coupon) {
        coupon = promoteService.insertCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }

    //获取详情中的信息
    @RequestMapping("/admin/coupon/read")
    public BaseRespVo readCoupon(int id) {
        Coupon coupon = promoteService.readCoupon(id);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }

    //详情中的查询
    @RequestMapping("/admin/coupon/listuser")
    public BaseRespVo getLIstUser(int page, int limit, String sort, String order, String couponId, String userId, String status) {
        ListBean lIstUser = promoteService.getLIstUser(page, limit, sort, order, couponId, userId, status);
        BaseRespVo ok = BaseRespVo.ok(lIstUser);
        return ok;
    }

    //编辑
    @RequestMapping("/admin/coupon/update")
    public BaseRespVo updateCoupon(@RequestBody Coupon coupon) {
        coupon = promoteService.updateCoupon(coupon);
        System.out.println(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }

    //删除
    @RequestMapping("/admin/coupon/delete")
    public BaseRespVo deleteCoupon(@RequestBody Coupon coupon) {
        promoteService.deleteCoupon(coupon);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(null);
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }
    /*------------------------------专题管理--------------------------------*/
    //获取页面信息
    @RequestMapping("/admin/topic/list")
    public BaseRespVo getTopicList(int page, int limit, String sort, String order, String title, String subtitle) {
        ListBean topicList = promoteService.getTopicList(page, limit, sort, order, title, subtitle);
        BaseRespVo ok = BaseRespVo.ok(topicList);
        return ok;
    }
    //添加专题
    @RequestMapping("/admin/topic/create")
    public BaseRespVo createTopic(@RequestBody Topic topic) {
        topic = promoteService.createTopic(topic);
        BaseRespVo ok = BaseRespVo.ok(topic);
        return ok;
    }
    //编辑专题
    @RequestMapping("/admin/topic/update")
    public BaseRespVo updateTopic(@RequestBody Topic topic) {
        topic = promoteService.updateTopic(topic);
        BaseRespVo ok = BaseRespVo.ok(topic);
        return ok;
    }
    //删除专题
    @RequestMapping("/admin/topic/delete")
    public BaseRespVo deleteTopic(@RequestBody Topic topic) {
        promoteService.deleteTopic(topic);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(null);
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }
}
