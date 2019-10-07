package com.cskaoyan.mall.vo.address;

import java.util.List;

/**
 * @author qyh
 * @date 2019/10/6 21:19
 */
public class FootListBean {
    List footprintList;
    Long totalPages;

    public List getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List footprintList) {
        this.footprintList = footprintList;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
