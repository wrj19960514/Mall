package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.bean.CartExample;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.OrderGoodsExample;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.CommentMapper;
import com.cskaoyan.mall.mapper.GoodsProductMapper;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderHandleOptionsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.util.DateUtils;
import com.cskaoyan.mall.vo.OrderComment;
import com.cskaoyan.mall.vo.OrderSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxOrderServiceImpl implements WxOrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    OrderHandleOptionsMapper optionsMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    CommentMapper commentMapper;

    private String[] strings = new String[]{"", "待付款", "待发货", "待收货", "待评价"};

    @Override
    public List getOrderList(int showType) {
        ArrayList list = new ArrayList();
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (showType != 0) {
            criteria.andOrderStatusEqualTo((short) showType);
        }
        List<Order> orders = orderMapper.selectByExample(example);
        for (Order order : orders) {
            HashMap map = new HashMap();
            map.put("handleOption", optionsMapper.queryRecordByOrderId(order.getId()));
            OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
            orderGoodsExample.createCriteria().andOrderIdEqualTo(order.getId());
            map.put("goodsList", orderGoodsMapper.selectByExample(orderGoodsExample));
            map.put("actualPrice", order.getActualPrice());
            map.put("id", order.getId());
            map.put("isGroupin", true); // TODO
            map.put("orderSn", order.getOrderSn());
            map.put("orderStatusText", strings[showType]);
            list.add(map);
        }
        return list;
    }

    @Override
    public Map getOrderDetail(int orderId) {
        HashMap map = new HashMap();
        map.put("orderGoods", getOrderGoods(orderId));
        map.put("orderInfo", getOrderInfo(orderId));
        return map;
    }

    private List getOrderGoods(int orderId) {
        ArrayList list = new ArrayList();
        OrderGoodsExample example = new OrderGoodsExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(example);
        for (OrderGoods goods : orderGoods) {
            HashMap map = new HashMap();
            map.put("addTime", DateUtils.toString(goods.getAddTime()));
            map.put("specifications", goods.getSpecifications());
            map.put("comment", goods.getComment());
            map.put("deleted", goods.getDeleted());
            map.put("goodsId", goods.getGoodsId());
            map.put("goodsName", goods.getGoodsName());
            map.put("goodsSn", goods.getGoodsSn());
            map.put("id", goods.getId());
            map.put("number", goods.getNumber());
            map.put("orderId", goods.getOrderId());
            map.put("picUrl", goods.getPicUrl()[0]);
            map.put("price", goods.getPrice());
            map.put("productId", goods.getProductId());
            map.put("updateTime", DateUtils.toString(goods.getUpdateTime()));
            list.add(map);
        }
        return list;
    }

    private HashMap getOrderInfo(int orderId) {
        HashMap map = new HashMap();
        map.put("handleOption", optionsMapper.queryRecordByOrderId(orderId));
        Order order = orderMapper.selectByPrimaryKey(orderId);
        map.put("actualPrice", order.getActualPrice());
        map.put("addTime", DateUtils.toString(order.getAddTime()));
        map.put("address", order.getAddress());
        map.put("consignee", order.getConsignee());
        map.put("freightPrice", order.getFreightPrice());
        map.put("goodsPrice", order.getGoodsPrice());
        map.put("id", order.getId());
        map.put("mobile", order.getMobile());
        map.put("orderSn", order.getOrderSn());
        map.put("orderStatusText", strings[order.getOrderStatus()]);
        return map;
    }

    @Override
    public void cancelOrder(int orderId) {
        // TODO 金额在哪
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderStatus((short) 0);
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        optionsMapper.updateCancelByOrderId(orderId, false);
        optionsMapper.updateRefundByOrderId(orderId, false);
        optionsMapper.updatePayByOrderId(orderId, false);
        optionsMapper.updateDeleteByOrderId(orderId, true);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentlByOrderId(orderId, false);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderStatus((short) 0);
        order.setDeleted(true);
        orderMapper.updateByPrimaryKey(order);
        optionsMapper.updateCancelByOrderId(orderId, false);
        optionsMapper.updateRefundByOrderId(orderId, false);
        optionsMapper.updatePayByOrderId(orderId, false);
        optionsMapper.updateDeleteByOrderId(orderId, false);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentlByOrderId(orderId, false);
    }

    @Override
    public void confirmOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderStatus((short) 4);
        order.setDeleted(false);
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        optionsMapper.updateCancelByOrderId(orderId, false);
        optionsMapper.updateRefundByOrderId(orderId, true);
        optionsMapper.updatePayByOrderId(orderId, false);
        optionsMapper.updateDeleteByOrderId(orderId, true);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentlByOrderId(orderId, true);
    }

    @Override
    public void refundOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderStatus((short) 4);
        order.setDeleted(false);
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        optionsMapper.updateCancelByOrderId(orderId, false);
        optionsMapper.updateRefundByOrderId(orderId, false);
        optionsMapper.updatePayByOrderId(orderId, false);
        optionsMapper.updateDeleteByOrderId(orderId, true);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentlByOrderId(orderId, true);
    }

    @Override
    public boolean submitOrder(OrderSubmitVo orderSubmitVo) {
        // TODO 添加多个商品至Order_Goods表
        List<Cart> carts = cartMapper.selectByExample(new CartExample());
        for (Cart cart : carts) {
            GoodsProduct goodsProduct = goodsProductMapper.selectByPrimaryKey(cart.getGoodsId());
            if ((goodsProduct.getNumber() - cart.getNumber()) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void prepayOrder(Integer orderId) {
        Order order = new Order();
        order.setId(orderId);
        order.setOrderStatus((short) 1);
        order.setDeleted(false);
        order.setAddTime(new Date());
        // order.setUserId(); TODO 添加三张表
        orderMapper.insert(order);
        optionsMapper.updateCancelByOrderId(orderId, true);
        optionsMapper.updateRefundByOrderId(orderId, false);
        optionsMapper.updatePayByOrderId(orderId, true);
        optionsMapper.updateDeleteByOrderId(orderId, false);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentlByOrderId(orderId, false);
    }

    @Override
    public Map getGoodsDetail(int orderId, int goodsId) {
        HashMap map = new HashMap();
        OrderGoodsExample example = new OrderGoodsExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId);
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(example);
        for (OrderGoods goods : orderGoods) {
            map.put("addTime", DateUtils.toString(goods.getAddTime()));
            map.put("specifications", goods.getSpecifications());
            map.put("comment", goods.getComment());
            map.put("deleted", goods.getDeleted());
            map.put("goodsId", goods.getGoodsId());
            map.put("goodsName", goods.getGoodsName());
            map.put("goodsSn", goods.getGoodsSn());
            map.put("id", goods.getId());
            map.put("number", goods.getNumber());
            map.put("orderId", goods.getOrderId());
            map.put("picUrl", goods.getPicUrl()[0]);
            map.put("price", goods.getPrice());
            map.put("productId", goods.getProductId());
            map.put("updateTime", DateUtils.toString(goods.getUpdateTime()));
        }
        return map;
    }

    @Override
    public boolean setGoodsComment(OrderComment orderComment) {
        if(orderComment.getPicUrls().length>3) {
            return false;
        }
        Comment comment = new Comment();
        comment.setValueId(orderComment.getOrderGoodsId());
        comment.setType((byte) 0);
        comment.setContent(orderComment.getContent());
        comment.setUserId(0); // TODO 无法判断
        if(orderComment.isHasPicture()){
            comment.setPicUrls(orderComment.getPicUrls());
            comment.setHasPicture(true);
        }
        comment.setHasPicture(false);
        comment.setAddTime(new Date());
        comment.setStar((short) orderComment.getStar());
        commentMapper.insert(comment);
        return true;
    }
}
