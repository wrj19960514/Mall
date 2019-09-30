package com.cskaoyan.mall.vo;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 11:47
 */
public class UserInfo {
    String avatar;
    String name;
    List roles;
    List perms;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public List getPerms() {
        return perms;
    }

    public void setPerms(List perms) {
        this.perms = perms;
    }
}
