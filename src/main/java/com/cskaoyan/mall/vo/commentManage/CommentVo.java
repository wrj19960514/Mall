package com.cskaoyan.mall.vo.commentManage;

import com.cskaoyan.mall.vo.UserInfo;

import java.util.Date;
import java.util.List;

public class CommentVo {
    UserInfo userInfo;
    Date addTime;
    String content;
    String[] picList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }
}
