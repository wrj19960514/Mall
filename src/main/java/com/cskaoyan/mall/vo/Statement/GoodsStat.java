package com.cskaoyan.mall.vo.Statement;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author adore
 * @date 2019/10/1 20:55
 */
public class GoodsStat {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date day;
    int orders;
    int products;
    double amount;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
