package com.cskaoyan.mall.vo.Statement;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author adore
 * @date 2019/10/1 19:45
 */
public class OrderStat {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date day;
    int orders;
    double amount;
    int customers;
    double pcr;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public double getPcr() {
        return pcr;
    }

    public void setPcr(double pcr) {
        this.pcr = pcr;
    }
}
