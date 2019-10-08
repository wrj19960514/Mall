package com.cskaoyan.mall.vo.wx;

import javax.validation.constraints.NotNull;

public class RegisterVo {
    @NotNull
    String username;

    @NotNull
    String password;

    @NotNull
    String mobile;

    @NotNull
    String code;

    String wxCode;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    @Override
    public String toString() {
        return "RegisterVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", code='" + code + '\'' +
                ", wxCode='" + wxCode + '\'' +
                '}';
    }
}
