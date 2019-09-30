package com.cskaoyan.mall.vo.mallManage;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.User;

import java.util.List;

public class OrderDetailedVo {
    private Order order;

    private List orderGoods;

    private User user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
