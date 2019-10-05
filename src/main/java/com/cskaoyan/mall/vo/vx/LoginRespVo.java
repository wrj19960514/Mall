package com.cskaoyan.mall.vo.vx;
import java.util.Map;

public class LoginRespVo {

    String token;

    String tokenExpire;

    Map<String,String> userInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(String tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public Map<String, String> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<String, String> userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginRespVo{" +
                "token='" + token + '\'' +
                ", tokenExpire='" + tokenExpire + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
