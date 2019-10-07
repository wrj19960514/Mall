package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.wx.WxOrderstateVo;

import java.util.Map;


public interface WxIndexService {

    WxOrderstateVo getuserIndex();

    Map<String, Object> gethomeIndex();

    Map<String, Object> getcatalogIndex();
}
