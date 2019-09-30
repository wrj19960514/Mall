package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.ListBean;

public interface UserService {
    ListBean getUserList(int page, int limit, String sort, String order, String username, String mobile);
}
