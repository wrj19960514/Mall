package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.vo.ListBean;

public interface UserService {
    ListBean getUserList(int page, int limit, String sort, String order, String username, String mobile);
    ListBean getAddressList(int page, int limit, String sort, String order, String userId, String name);
    ListBean getCollectList(int page, int limit, String sort, String order, String userId, String valueId);
    ListBean getFootprintList(int page, int limit, String sort, String order, String userId, String goodsId);
    ListBean getHistoryList(int page, int limit, String sort, String order, String userId, String keyword);
    ListBean getFeedbackList(int page, int limit, String sort, String order, String username, String id);
}
