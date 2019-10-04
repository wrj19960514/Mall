package com.cskaoyan.mall.bean;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class GoodsAttribute {
    private Integer id;

    private Integer goodsId;

    @NotNull(message = "参数名称不能为空")
    private String attribute;

    @NotNull(message = "参数值不能为空")
    private String value;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "GoodsAttribute{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}