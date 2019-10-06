package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.CouponService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 19:20
 */
@RestController
@RequestMapping("wx/coupon")
public class CouponController {
    @Autowired
    CouponService couponService;
    @RequestMapping("list")
    public BaseRespVo getCouponList(int page, int size) {
        Map map = couponService.getCouponList(page, size);
        return BaseRespVo.ok(map);
    }

    @RequestMapping("receive")
    public BaseRespVo receive(int couponId) {
        return couponService.receive(couponId);
    }
}
