package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.adminManage.PermReqVo;
import com.cskaoyan.mall.vo.adminManage.PermVo;
import com.cskaoyan.mall.vo.adminManage.RoleVo;

import java.util.List;

public interface RoleService {
    List<RoleVo> queryAllRoles();

    ListBean selectAllRoles(int page, int limit, String sort, String order);

    ListBean selectRolesByName(int page, int limit, String name, String sort, String order);

    Role insertRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    PermVo selectPermissionsByRoleId(int roleId);

    void updatePermissionsByRoleId(PermReqVo permReqVo);
}
