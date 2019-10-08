package com.cskaoyan.mall.shiro;

import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.vo.RoleIdsVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author adore
 * @date 2019/10/4 19:18
 */
@Component
public class AdminRealm extends AuthorizingRealm {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    PermissionMapper permissionMapper;
    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // username
        String principal = (String) authenticationToken.getPrincipal();
        String password = adminMapper.queryPasswordByUsername(principal);
        // 进行认证
        return new SimpleAuthenticationInfo(principal,password,this.getName());
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // username
        String principal = (String) principalCollection.getPrimaryPrincipal();
        // 授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 查询所有的身份信息
        RoleIdsVo roleIdsVo = adminMapper.queryRoleIdsByUsername(principal);
        // 查询所有权限
        Integer[] roleIds = roleIdsVo.getRoleIds();
        List<String> permissions = permissionMapper.queryPermissionsByRoleIds(roleIds);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
