package com.cskaoyan.mall.vo;

public class OrderComment {
    private String content;

    private boolean hasPicture;

    private int orderGoodsId;

    private String[] picUrls;

    private int star;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public int getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(int orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
