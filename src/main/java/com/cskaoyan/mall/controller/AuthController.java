package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.LoginVo;
import com.cskaoyan.mall.vo.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author adore
 * @date 2019/9/30 11:26
 */
@RestController
@RequestMapping("/admin/auth")
public class AuthController {
    @RequestMapping("/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo) {
        BaseRespVo ok = BaseRespVo.ok("595bff99-b2db-4e3f-9f3d-15ea6a04a942");
        return ok;
    }

    @RequestMapping("/info")
    public BaseRespVo info(String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setName("admin123");
        ArrayList roles = new ArrayList();
        roles.add("超级管理员");
        userInfo.setRoles(roles);
        ArrayList perms = new ArrayList();
        perms.add("*");
        userInfo.setPerms(perms);
        BaseRespVo ok = BaseRespVo.ok(userInfo);
        return ok;
    }

    @RequestMapping("/logout")
    public BaseRespVo logout() {
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}
