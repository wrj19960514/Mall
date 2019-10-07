package com.cskaoyan.mall.vo.promote;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.Order;

import java.util.List;

/**
 * @author adore
 * @date 2019/10/6 14:14
 */
public class GrouponDetailVo {
    Creator creator;
    Groupon groupon;
    List<Creator> joiners;
    int linkGrouponId;
    List<OrderGood> orderGoods;
    Order orderInfo;
    GrouponRules rules;

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public List<Creator> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<Creator> joiners) {
        this.joiners = joiners;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public List<OrderGood> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGood> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Order getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Order orderInfo) {
        this.orderInfo = orderInfo;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }
}
