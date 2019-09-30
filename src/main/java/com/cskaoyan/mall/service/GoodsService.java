package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.ListBean;


/**
 * @author adore
 * @date 2019/9/30 14:40
 */
public interface GoodsService {
    /**获取商品列表
     * @param page 当前页
     * @param limit 页面条目数
     * @param sort 排序字段
     * @param order 升序/降序
     * @return 商品列表
     */
    ListBean getGoodsList(int page, int limit, String sort, String order);
}
