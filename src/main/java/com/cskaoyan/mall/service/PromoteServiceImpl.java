package com.cskaoyan.mall.service;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.AdExample;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.CouponExample;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoteServiceImpl implements PromoteService {

    @Autowired
    AdMapper adMapper;

    @Autowired
    CouponMapper couponMapper;

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
    public Ad updateAds(Ad ad) {
        AdExample adExample = new AdExample();
        adExample.createCriteria().andIdEqualTo(ad.getId());
        int i = adMapper.updateByExample(ad, adExample);
        return adMapper.selectByPrimaryKey(ad.getId());
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
}
