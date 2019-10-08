package com.cskaoyan.mall.vo.promote;

import com.cskaoyan.mall.bean.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author adore
 * @date 2019/10/5 19:29
 */
public class MyGrouponVo {
    BigDecimal actualPrice;
    String creator;
    List<OrderGoods> goodsList;
    Groupon groupon;
    OrderHandleoption handleoption;
    int id;
    boolean isCreator;
    int joinerCount;
    int orderId;
    String orderSn;
    String orderStatusText;
    GrouponRules rules;

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public OrderHandleoption getHandleoption() {
        return handleoption;
    }

    public void setHandleoption(OrderHandleoption handleoption) {
        this.handleoption = handleoption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }


    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }
}
