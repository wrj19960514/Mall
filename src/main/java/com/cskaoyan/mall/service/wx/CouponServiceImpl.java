package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.CouponExample;
import com.cskaoyan.mall.bean.CouponUser;
import com.cskaoyan.mall.bean.CouponUserExample;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.mapper.CouponUserMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 19:24
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponUserMapper couponUserMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Map getCouponList(int page, int size) {
        PageHelper.startPage(page, size);
        CouponExample couponExample = new CouponExample();
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", coupons);
        map.put("count", total);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public BaseRespVo receive(int couponId) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        // 获取userId
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        int userId = userMapper.queryUserIdByUsername(principal);
        // 优惠券信息
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        Integer total = coupon.getTotal();
        if (total >= 0) {
            // 限制只能领取一张时, 检查是否已经领取过了
            if (coupon.getLimit() == 1) {
                CouponUserExample couponUserExample = new CouponUserExample();
                couponUserExample.createCriteria().andUserIdEqualTo(userId).andCouponIdEqualTo(couponId);
                List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
                if (couponUsers.size() > 0) {
                    baseRespVo.setErrmsg("你已经领取过了");
                    baseRespVo.setErrno(740);
                    return baseRespVo;
                }
            }
            // 可以领取优惠券
            // 领取优惠券数量减少
            coupon.setTotal(total - 1 == 0 ? -1 : total - 1);
            couponMapper.updateByPrimaryKey(coupon);
            // 封装领取的优惠券
            CouponUser couponUser = new CouponUser();
            couponUser.setUserId(userId);
            couponUser.setCouponId(couponId);
            couponUser.setStatus(coupon.getStatus());
            couponUser.setStartTime(coupon.getStartTime());
            couponUser.setEndTime(coupon.getEndTime());
            Date date = new Date();
            couponUser.setAddTime(date);
            couponUser.setUpdateTime(date);
            // 领取的优惠券存入数据库
            couponUserMapper.insert(couponUser);
        } else {
            baseRespVo.setErrmsg("优惠券已经领完了");
            baseRespVo.setErrno(740);
            return baseRespVo;
        }
        baseRespVo.setErrmsg("领取成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
}
