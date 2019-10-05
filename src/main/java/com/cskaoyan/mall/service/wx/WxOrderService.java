package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.OrderComment;
import com.cskaoyan.mall.vo.OrderSubmitVo;

import java.util.List;
import java.util.Map;

public interface WxOrderService {
    List getOrderList(int showType);

    Map getOrderDetail(int orderId);

    void cancelOrder(int orderId);

    void deleteOrder(Integer orderId);

    void confirmOrder(Integer orderId);

    void refundOrder(Integer orderId);

    boolean submitOrder(OrderSubmitVo orderSubmitVo);

    void prepayOrder(Integer orderId);

    Map getGoodsDetail(int orderId, int goodsId);

    boolean setGoodsComment(OrderComment orderComment);
}
