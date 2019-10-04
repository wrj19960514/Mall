package com.cskaoyan.mall.vo.adminManage;

import java.util.List;

public class PermRespVo {
    int idz;
    String id;
    String label;
    String api;
    List children ;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getIdz() {
        return idz;
    }

    public void setIdz(int idz) {
        this.idz = idz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
