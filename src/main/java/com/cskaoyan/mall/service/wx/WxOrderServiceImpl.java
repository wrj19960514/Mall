package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.bean.OrderGoodsExample;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderHandleOptionsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WxOrderServiceImpl implements WxOrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    OrderHandleOptionsMapper optionsMapper;

    @Override
    public List getOrderList(int showType) {
        String[] strings = new String[]{"", "待付款", "待发货", "待收货", "待评价"};
        ArrayList list = new ArrayList();
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
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
}
