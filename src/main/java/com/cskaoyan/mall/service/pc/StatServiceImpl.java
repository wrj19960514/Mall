package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.Statement.GoodsStat;
import com.cskaoyan.mall.vo.Statement.OrderStat;
import com.cskaoyan.mall.vo.Statement.StatVo;
import com.cskaoyan.mall.vo.Statement.UserStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adore
 * @date 2019/10/1 17:42
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Override
    public StatVo userStatement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("day");
        list.add("users");
        List<UserStat> userStatList = userMapper.getUserStatement();
        StatVo<UserStat> statVo = new StatVo<>();
        statVo.setColumns(list);
        statVo.setRows(userStatList);
        return statVo;
    }

    @Override
    public StatVo orderStatement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("day");
        list.add("orders");
        list.add("pcr");
        list.add("amount");
        list.add("customers");
        List<OrderStat> orderStatList = orderMapper.getOrderStatement();
        StatVo<OrderStat> statVo = new StatVo<>();
        statVo.setColumns(list);
        statVo.setRows(orderStatList);
        return statVo;
    }

    @Override
    public StatVo goodsStatement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("day");
        list.add("orders");
        list.add("products");
        list.add("amount");
        List<GoodsStat> goodsStatList = orderGoodsMapper.getGoodsStatement();
        StatVo<GoodsStat> statVo = new StatVo<>();
        statVo.setColumns(list);
        statVo.setRows(goodsStatList);
        return statVo;
    }
}
