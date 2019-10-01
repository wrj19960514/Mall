package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.vo.ListBean;

public interface PromoteService {
    /**
     * 广告管理:获取广告
     * @param page  页面数
     * @param limit  每页显示的条数
     * @param sort  根据sort排序
     * @param order   排序的的顺序 升序/降序
     * @param name   广告的标题
     * @param content 广告的内容
     * @return  返回的广告数
     */
    ListBean getAdList(int page, int limit, String sort, String order, String name, String content);

    Ad updateAds(Ad ad);

    void deleteAds(Ad ad);
}
