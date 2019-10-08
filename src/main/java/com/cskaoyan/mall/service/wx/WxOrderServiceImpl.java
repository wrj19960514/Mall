package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.util.DateUtils;
import com.cskaoyan.mall.vo.OrderComment;
import com.cskaoyan.mall.vo.OrderSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    GoodsMapper goodsMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    AddressMapper addressMapper;

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
        optionsMapper.updateCommentByOrderId(orderId, false);
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
        optionsMapper.updateCommentByOrderId(orderId, false);
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
        optionsMapper.updateCommentByOrderId(orderId, true);
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
        optionsMapper.updateCommentByOrderId(orderId, true);
    }

    @Override
    public int submitOrder(OrderSubmitVo orderSubmitVo) {
        List<Cart> carts = cartMapper.selectByExample(new CartExample());
        for (Cart cart : carts) {
            GoodsProduct goodsProduct =
                    goodsProductMapper.selectProductsByGoodsId(cart.getGoodsId()).get(0);
            if ((goodsProduct.getNumber() - cart.getNumber()) < 0) {
                return 0;
            }
            goodsProduct.setNumber(goodsProduct.getNumber() - cart.getNumber());
            goodsProductMapper.updateByPrimaryKey(goodsProduct);
        }

        // 插入记录到order、order_goods、order_handleOption
        // 查找order表最新的记录
        OrderExample example = new OrderExample();
        example.setOrderByClause("id DESC");
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders.size() == 0) {
            Order order = new Order();
            order.setId(0);
            order.setOrderSn("20191008000000001");
            order.setPayId(Integer.toString(1));
            orders.add(order);
        }
        Order lastOrder = orders.get(0);
        Integer lastId = lastOrder.getId();
        String s = lastOrder.getOrderSn().substring(8);
        int lastOrderSn = Integer.parseInt(s);
        Cart cart = carts.get(0);

        // 查询User
        User user = userMapper.selectByPrimaryKey(cart.getUserId());
        // 插入记录到order表
        Order order = new Order();
        order.setId(lastId + 1);
        order.setUserId(user.getId());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String s1 = format.format(new Date());
        order.setOrderSn(s1 + (lastOrderSn + 1));
        order.setOrderStatus((short) 1);
        order.setConsignee(user.getUsername());
        order.setMobile(user.getMobile());
        order.setAddress("湖北省武汉市洪山区花山镇花山大道软件新城2期C13");
        order.setMessage(orderSubmitVo.getMessage());
        BigDecimal price = new BigDecimal(0);
        for (Cart c : carts) {
            GoodsProduct goodsProduct =
                    goodsProductMapper.selectProductsByGoodsId(cart.getGoodsId()).get(0);
            int singlePrice = goodsProduct.getPrice().intValue();
            int priceN = singlePrice * c.getNumber();
            price = price.add(new BigDecimal(priceN));
        }
        order.setGoodsPrice(price);
        order.setFreightPrice(new BigDecimal(10));
        Coupon coupon = couponMapper.selectByPrimaryKey(orderSubmitVo.getCouponId());
        int discount = coupon.getDiscount().intValue();
        int totalPrice = price.intValue();
        totalPrice = (1 - discount/100) * totalPrice;
        int actualPrice = totalPrice + 10;
        order.setCouponPrice(new BigDecimal(totalPrice));
        order.setIntegralPrice(new BigDecimal(0));
        order.setGrouponPrice(new BigDecimal(0));
        order.setActualPrice(new BigDecimal(actualPrice));
        order.setOrderPrice(new BigDecimal(actualPrice));
        order.setPayId(Integer.toString(Integer.parseInt(lastOrder.getPayId()) + 1));
        order.setShipSn("快递备注");
        order.setComments((short) 0);
        order.setAddTime(new Date());
        order.setUpdateTime(new Date());
        order.setDeleted(false);
        orderMapper.insert(order);

        // 插入记录到order_handleOption表
        optionsMapper.insertRecord(lastId + 1);
        optionsMapper.updateCancelByOrderId(lastId + 1, true);
        optionsMapper.updatePayByOrderId(lastId + 1, true);

        // 插入记录到order_goods表
        for (Cart c : carts) {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrderId(lastId + 1);
            orderGoods.setGoodsId(c.getGoodsId());
            orderGoods.setGoodsName(c.getGoodsName());
            orderGoods.setGoodsSn(c.getGoodsSn());
            orderGoods.setProductId(c.getProductId());
            orderGoods.setNumber(c.getNumber());
            orderGoods.setPrice(c.getPrice());
            orderGoods.setSpecifications(c.getSpecifications());
            orderGoods.setPicUrl(new String[]{c.getPicUrl()});
            orderGoods.setUpdateTime(new Date());
            orderGoods.setAddTime(new Date());
            orderGoods.setDeleted(false);
            orderGoodsMapper.insert(orderGoods);
        }
        // 清空购物车
        cartMapper.deleteByExample(new CartExample());
        return order.getId();
    }

    @Override
    public void prepayOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setId(orderId);
        order.setOrderStatus((short) 2);
        order.setDeleted(false);
        order.setAddTime(new Date());
        order.setUpdateTime(new Date());
        order.setPayTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        optionsMapper.updateCancelByOrderId(orderId, true);
        optionsMapper.updateRefundByOrderId(orderId, false);
        optionsMapper.updatePayByOrderId(orderId, false);
        optionsMapper.updateDeleteByOrderId(orderId, false);
        optionsMapper.updateConfirmByOrderId(orderId, false);
        optionsMapper.updateCommentByOrderId(orderId, false);
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
        if (orderComment.getPicUrls().length > 3) {
            return false;
        }
        Comment comment = new Comment();
        comment.setValueId(orderComment.getOrderGoodsId());
        comment.setType((byte) 0);
        comment.setContent(orderComment.getContent());
        comment.setUserId(0); // TODO 无法判断
        if (orderComment.isHasPicture()) {
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
