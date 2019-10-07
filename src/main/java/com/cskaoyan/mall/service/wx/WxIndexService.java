package com.cskaoyan.mall.service.wx;

import java.util.Map;


public interface WxIndexService {

    Map<String,Object> getuserIndex();

    Map<String, Object> gethomeIndex();

    Map<String, Object> getcatalogIndex();
}
