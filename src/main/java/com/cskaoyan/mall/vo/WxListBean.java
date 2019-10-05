package com.cskaoyan.mall.vo;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 16:17
 */
public class WxListBean {
    List data;
    long total;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
