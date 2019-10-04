package com.cskaoyan.mall.vo.adminManage;

import java.util.List;

public class PermReqVo {
    int roleId;
    List permissions;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List getPermissions() {
        return permissions;
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }
}
