package com.cskaoyan.mall.service.wx;

import java.util.List;
import java.util.Map;

public interface WxOrderService {
    List getOrderList(int showType);

    Map getOrderDetail(int orderId);

    void cancelOrder(int orderId);
}
