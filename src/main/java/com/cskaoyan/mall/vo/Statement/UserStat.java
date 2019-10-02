package com.cskaoyan.mall.vo.Statement;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author adore
 * @date 2019/10/1 18:02
 */
public class UserStat {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date day;
    int users;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
