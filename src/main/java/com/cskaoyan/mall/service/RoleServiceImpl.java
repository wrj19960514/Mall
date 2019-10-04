package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.adminManage.PermReqVo;
import com.cskaoyan.mall.vo.adminManage.PermVo;
import com.cskaoyan.mall.vo.adminManage.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleVo> queryAllRoles() {
        List<RoleVo> roleVos = roleMapper.queryAllRoles();
        return roleVos;
    }

    @Override
    public ListBean selectAllRoles(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Role> roles = roleMapper.selectAllRoles(sort, order);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        long total = rolePageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(roles);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean selectRolesByName(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        name = "%" + name + "%";
        List<Role> roles = roleMapper.selectRolesByName(name, sort, order);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        long total = rolePageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setTotal(total);
        listBean.setItems(roles);
        return listBean;
    }

    @Override
    public Role insertRole(Role role) {
        Date date = new Date();
        role.setAddTime(date);
        role.setUpdateTime(date);
        //把role插入到表中
        roleMapper.insertRole(role);
        ///根据name查询插入数据的id
        String name = role.getName();
        int id = roleMapper.queryIdByName(name);
        role.setId(id);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        Date date = new Date();
        role.setUpdateTime(date);
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        Integer id = role.getId();
        roleMapper.deleteRole(id);
    }

    @Override
    public PermVo selectPermissionsByRoleId(int roleId) {

        List permsByRoleId = roleMapper.selectPermissionsByRoleId(roleId);
        List allPerms = roleMapper.selectAllPermissions();
        PermVo permVo = new PermVo();
        permVo.setAssignedPermissions(permsByRoleId);
        permVo.setSystemPermissions(allPerms);
        return permVo;
    }

    @Override
    public void updatePermissionsByRoleId(PermReqVo permReqVo) {
        Date date = new Date();
        Integer roleId = permReqVo.getRoleId();
        List<String> permissions = permReqVo.getPermissions();
        roleMapper.deletePermsByRoleId(roleId);
        for (String permission : permissions) {
            roleMapper.insertPermsByRoleId(roleId,permission,date);
        }
    }
}
