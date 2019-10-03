package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.LogService;
import com.cskaoyan.mall.service.RoleService;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.adminManage.AddAdminVo;
import com.cskaoyan.mall.vo.adminManage.AdminVo;
import com.cskaoyan.mall.vo.adminManage.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    RoleService roleService;
    @Autowired
    LogService logService;
    @Autowired
    StorageService storageService;

    @RequestMapping("admin/role/options")
    public BaseRespVo getRoleList() {
        List<RoleVo> data = roleService.queryAllRoles();
        BaseRespVo ok = BaseRespVo.ok(data);
        return ok;
    }

    @RequestMapping("admin/admin/list")
    public BaseRespVo getAdminList(int page, int limit, String username, String sort, String order) throws IOException {
        if (username != null) {
            ListBean data = adminService.queryAdminsByUsername(page, limit, username, sort, order);
            BaseRespVo ok = BaseRespVo.ok(data);
            return ok;
        } else {
            ListBean data = adminService.queryAllAdmins(page, limit, sort, order);
            BaseRespVo ok = BaseRespVo.ok(data);
            return ok;
        }

    }

    @RequestMapping("admin/admin/delete")
    public BaseRespVo DeleteAdmin(@RequestBody AdminVo adminVo) {
        adminService.deleteAdminById(adminVo);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

    @RequestMapping("admin/admin/create")
    public BaseRespVo addAdmin(@RequestBody AddAdminVo addAdminVo) {
        AddAdminVo addAdminVo1 = adminService.insertAdmin(addAdminVo);
        BaseRespVo ok = BaseRespVo.ok(addAdminVo1);
        return ok;
    }

    @RequestMapping("admin/admin/update")
    public BaseRespVo updateAdmin(@RequestBody AddAdminVo addAdminVo) {
        AddAdminVo addAdminVo1 = adminService.updateAdminById(addAdminVo);
        BaseRespVo ok = BaseRespVo.ok(addAdminVo1);
        return ok;
    }

    @RequestMapping("admin/log/list")
    public BaseRespVo getLogList(int page, int limit, String name, String sort, String order) {
        if (name != null) {
            ListBean listBean = logService.queryLogsByName(page, limit, name, sort, order);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        } else {
            ListBean listBean = logService.queryAllLogs(page, limit, sort, order);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        }
    }

    @RequestMapping("admin/role/list")
    public BaseRespVo getRolesList(int page, int limit, String name, String sort, String order) {
        if (name != null) {
            ListBean listBean = roleService.selectRolesByName(page, limit, name, sort, order);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        } else {
            ListBean listBean = roleService.selectAllRoles(page, limit, sort, order);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        }
    }
    @RequestMapping("admin/role/create")
    public BaseRespVo addRole(@RequestBody Role role) {
        Role role1 = roleService.insertRole(role);
        BaseRespVo ok = BaseRespVo.ok(role1);
        return ok;
    }
    @RequestMapping("admin/role/update")
    public BaseRespVo updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
    @RequestMapping("admin/role/delete")
    public BaseRespVo deleteRole(@RequestBody Role role) {
        roleService.deleteRole(role);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
  /*  @RequestMapping("admin/storage/list")
    public BaseRespVo getStorageList(int page,int limit,String sort,String order,String key,String name) {
        if(key!= null || name!= null){
            ListBean listBean = storageService.queryStorageByKeyAndName(page, limit, sort, order, key, name);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        }else{
            ListBean listBean = storageService.queryAllStorage(page, limit, sort, order);
            BaseRespVo ok = BaseRespVo.ok(listBean);
            return ok;
        }
    }
    @RequestMapping("admin/storage/update")
    public BaseRespVo updateStorage(@RequestBody Storage storage) {
        storageService.updateStorage(storage);
        BaseRespVo ok = BaseRespVo.ok(storage);
        return ok;
    }
    @RequestMapping("admin/storage/delete")
    public BaseRespVo deleteStorage(@RequestBody Storage storage) {
        storageService.deleteStorage(storage);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }*/
}
