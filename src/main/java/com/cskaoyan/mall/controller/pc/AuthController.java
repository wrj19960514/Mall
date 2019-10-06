package com.cskaoyan.mall.controller.pc;

import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.shiro.CustomToken;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.LoginVo;
import com.cskaoyan.mall.vo.RoleIdsVo;
import com.cskaoyan.mall.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 11:26
 */
@RestController
@RequestMapping("/admin/auth")
public class AuthController {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @RequestMapping("/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        CustomToken token = new CustomToken(username, password,"admin");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail();
        }
        // 返回session的id
        Serializable id = subject.getSession().getId();
        return BaseRespVo.ok(id);
    }

    @RequestMapping("/info")
    public BaseRespVo info(String token) {

        Subject subject = SecurityUtils.getSubject();
        // username
        String principal = (String) subject.getPrincipal();
        // 获取管理员角色权限信息
        RoleIdsVo roleIdsVo = adminMapper.queryRoleIdsByUsername(principal);
        Integer[] roleIds = roleIdsVo.getRoleIds();
        List<String> roleNames = roleMapper.queryRoleNameByRoleIds(roleIds);
        List<String> permissions = permissionMapper.queryPermissionsByRoleIds(roleIds);
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setName(principal);
        userInfo.setPerms(permissions);
        userInfo.setRoles(roleNames);
        return BaseRespVo.ok(userInfo);
    }

    @RequestMapping("/logout")
    public BaseRespVo logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok(null);
    }
}
