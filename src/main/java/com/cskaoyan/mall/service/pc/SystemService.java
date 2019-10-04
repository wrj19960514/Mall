package com.cskaoyan.mall.service.pc;


import com.cskaoyan.mall.bean.LiteMall;

import java.util.Map;

public interface SystemService {
    /**
     * 获取商场配置信息
     * @return
     */
    Map<String,String> getMall();
    /**
     * 获取运费配置信息
     * @return
     */
    Map<String,String> getExpress();
    /**
     * 获取订单配置信息
     * @return
     */
    Map<String,String> getOrder();

    /**
     * 获取微信配置信息
     * @return
     */
    Map<String,String> getWx();

    /**
     * 更新商场配置信息
     * @param liteMall
     * @return
     */
    boolean updateMall(LiteMall liteMall);
    /**
     * 更新运费配置信息
     * @param liteMall
     * @return
     */
    boolean updateExpress(LiteMall liteMall);
    /**
     * 更新订单配置信息
     * @param liteMall
     * @return
     */
    boolean updateOrder(LiteMall liteMall);

    /**
     * 更新微信配置信息
     * @param liteMall
     * @return
     */
    boolean updateWx(LiteMall liteMall);
}
