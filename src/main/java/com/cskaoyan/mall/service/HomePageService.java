package com.cskaoyan.mall.service;


import java.util.Map;

public interface HomePageService {
    /**
     * 获取首页统计信息
     * @return
     */
    Map<String, Integer> getDashboard();
}
