package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.ListBean;

public interface LogService {
    ListBean queryAllLogs(int page, int limit, String sort, String order);

    ListBean queryLogsByName(int page, int limit, String name, String sort, String order);

}
