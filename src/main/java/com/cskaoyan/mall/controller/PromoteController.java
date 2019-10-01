package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.Coupon2;
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
    @RequestMapping(value = "/admin/coupon/create", produces = "application/json")
    public BaseRespVo insertCoupon(@RequestBody Coupon coupon) {
        System.out.println(coupon);

        coupon = promoteService.insertCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }
}
