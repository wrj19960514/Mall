package com.cskaoyan.mall.vo.goodsManage;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 19:48
 */
public class CategoryList {
    String value;
    String label;
    List<Label> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Label> getChildren() {
        return children;
    }

    public void setChildren(List<Label> children) {
        this.children = children;
    }
}
