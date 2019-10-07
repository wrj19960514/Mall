package com.cskaoyan.mall.vo.promote;

import java.math.BigDecimal;

/**
 * @author adore
 * @date 2019/10/6 14:20
 */
public class OrderGood{
    int goodsId;
    String goodsName;
    String[] goodsSpecificationValues;
    int id;
    int number;
    int orderId;
    String picUrl;
    BigDecimal retailPrice;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String[] getGoodsSpecificationValues() {
        return goodsSpecificationValues;
    }

    public void setGoodsSpecificationValues(String[] goodsSpecificationValues) {
        this.goodsSpecificationValues = goodsSpecificationValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}
