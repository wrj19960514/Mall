package com.cskaoyan.mall.vo.wx;

import com.cskaoyan.mall.bean.*;

import java.util.List;

public class WxGoodsDetailVo {

    private boolean userHasCollect;
    private String shareImage;
    private Comment comment;
    private Brand brand;
    private List<SpecificationList> specificationList;
    private List<GrouponRules> groupon;
    private List<Issue> Issue;
    private List<GoodsAttribute> attributes;
    private List<GoodsProduct> productList;
    private Goods info;

    public WxGoodsDetailVo() {
    }

    public WxGoodsDetailVo(boolean userHasCollect, String shareImage, Comment comment, Brand brand, List<SpecificationList> specificationList, List<GrouponRules> groupon, List<com.cskaoyan.mall.bean.Issue> issue, List<GoodsAttribute> attributes, List<GoodsProduct> productList, Goods info) {
        this.userHasCollect = userHasCollect;
        this.shareImage = shareImage;
        this.comment = comment;
        this.brand = brand;
        this.specificationList = specificationList;
        this.groupon = groupon;
        Issue = issue;
        this.attributes = attributes;
        this.productList = productList;
        this.info = info;
    }

    public boolean isUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(boolean userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<SpecificationList> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationList> specificationList) {
        this.specificationList = specificationList;
    }

    public List<GrouponRules> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<GrouponRules> groupon) {
        this.groupon = groupon;
    }

    public List<com.cskaoyan.mall.bean.Issue> getIssue() {
        return Issue;
    }

    public void setIssue(List<com.cskaoyan.mall.bean.Issue> issue) {
        Issue = issue;
    }

    public List<GoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<GoodsProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<GoodsProduct> productList) {
        this.productList = productList;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }
}
