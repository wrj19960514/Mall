package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.ListBean;

public interface UserService {
    ListBean getUserList(int page, int limit, String sort, String order, String username, String mobile);
    ListBean getAddressList(int page, int limit, String sort, String order, String user_id, String name);
    ListBean getCollectList(int page, int limit, String sort, String order, String user_id, String value_id);
    ListBean getFootprintList(int page, int limit, String sort, String order, String user_id, String goods_id);
    ListBean getHistoryList(int page, int limit, String sort, String order, String user_id, String keyword);
    ListBean getFeedbackList(int page, int limit, String sort, String order, String username, String id);
}
