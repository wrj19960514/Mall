package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.LiteMall;

import java.util.Map;

public interface SystemService {
    Map<String,String> getMall();

    Map<String,String> getExpress();

    Map<String,String> getOrder();

    Map<String,String> getWx();

    boolean updateMall(LiteMall liteMall);

    boolean updateExpress(LiteMall liteMall);

    boolean updateOrder(LiteMall liteMall);

    boolean updateWx(LiteMall liteMall);
}
