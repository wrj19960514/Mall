package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.OrderDetailedVo;
import com.cskaoyan.mall.vo.mallManage.OrderListVo;

import java.util.List;

public interface MallManageService {
    List getRegionList(int i, int i2);

    List getBrandList(BrandInfoVo brandInfoVo);

    void deleteBrand(Integer id, Boolean deleted);

    void createBrand(BrandCreateVo brandCreateVo);

    List getOrderList(OrderListVo orderListVo);

    OrderDetailedVo getOrderDetailed(int id);
}
