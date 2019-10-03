package com.cskaoyan.mall.vo.mallManage;

public class OrderListVo {
    private int page;

    private int limit;

    private String sort;

    private String order;

    private String userId;

    private String orderSn;

    private int orderStatusArray;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getOrderStatusArray() {
        return orderStatusArray;
    }

    public void setOrderStatusArray(int orderStatusArray) {
        this.orderStatusArray = orderStatusArray;
    }
}
