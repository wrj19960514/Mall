package com.cskaoyan.mall.service.wx;


import java.util.Map;

public interface WxCartService {

    boolean updateCart(int goodsId, int productId, int number, int id);

    void deleteCart(int[] productId);

    Map<String, Object> getIndex();
}
