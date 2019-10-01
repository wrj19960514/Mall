package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.bean.GoodsProductExample;
import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.GoodsProductMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Map<String, Integer> getDashboard() {
        Map<String,Integer> map = new HashMap<>(100);

        GoodsExample goodsExample = new GoodsExample();
        UserExample userExample = new UserExample();
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        OrderExample orderExample = new OrderExample();

        map.put("goodsTotal",(int)goodsMapper.countByExample(goodsExample));
        map.put("userTotal",(int)userMapper.countByExample(userExample));
        map.put("productTotal",(int)goodsProductMapper.countByExample(goodsProductExample));
        map.put("orderTotal",(int)orderMapper.countByExample(orderExample));
        return map;
    }
}
