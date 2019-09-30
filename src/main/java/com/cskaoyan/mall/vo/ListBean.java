package com.cskaoyan.mall.vo;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 16:17
 */
public class ListBean {
    List items;
    long total;

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
