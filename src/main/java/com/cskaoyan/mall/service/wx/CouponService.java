package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.vo.BaseRespVo;

import java.util.List;
import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 19:24
 */
public interface CouponService {
    Map getCouponList(int page, int size);

    BaseRespVo receive(int couponId);

    Map myCouponList(short status, int page, int size);

    BaseRespVo exchange(String code);

    List<Coupon> selectList(int cartId, int grouponRulesId);
}
