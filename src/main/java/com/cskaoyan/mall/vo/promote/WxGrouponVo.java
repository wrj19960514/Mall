package com.cskaoyan.mall.vo.promote;

import com.cskaoyan.mall.bean.Goods;

import java.math.BigDecimal;

/**
 * @author adore
 * @date 2019/10/5 15:11
 */
public class WxGrouponVo {
    Goods goods;
    Integer groupon_member;
    BigDecimal groupon_price;

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
