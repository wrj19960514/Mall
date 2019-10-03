package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.adminManage.AddAdminVo;
import com.cskaoyan.mall.vo.adminManage.AdminVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public ListBean queryAllAdmins(int page, int limit, String sort, String order) throws IOException {
        //进行分页
        PageHelper.startPage(page, limit);
        //查询所有的管理员并进行排序
        List<Admin> admins = adminMapper.queryAllAdmin(sort, order);
        //进行求和total
        PageInfo<Admin> adPageInfo = new PageInfo<>(admins);
        long total = adPageInfo.getTotal();
        //对查询出来的管理员admins进行重新封装到新的List里面
        List<AdminVo> adminVos = new ArrayList<>();
        for (Admin admin : admins) {
            AdminVo adminVo = new AdminVo();
            adminVo.setId(admin.getId());
            adminVo.setUsername(admin.getUsername());
            adminVo.setAvatar(admin.getAvatar());
            String roleIds = admin.getRoleIds();
            //把string类型的roleIds装换成数组类型
            ObjectMapper objectMapper = new ObjectMapper();
            Integer[] integers = objectMapper.readValue(roleIds, Integer[].class);
            adminVo.setRoleIds(integers);
            adminVos.add(adminVo);
        }
        //封装listBean并返回
        ListBean listBean = new ListBean();
        listBean.setTotal(total);
        listBean.setItems(adminVos);
        return listBean;
    }

    @Override
    public ListBean queryAdminsByUsername(int page, int limit, String username, String sort, String order) throws IOException {
        //分页
        PageHelper.startPage(page, limit);
        //根据username进行模糊查询
        username = "%" + username + "%";
        List<Admin> admins = adminMapper.queryAdminsByUsername(sort, order, username);
        //求和
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        long total = adminPageInfo.getTotal();
        List<AdminVo> adminVos = new ArrayList<>();
        for (Admin admin : admins) {
            AdminVo adminVo = new AdminVo();
            adminVo.setId(admin.getId());
            adminVo.setUsername(admin.getUsername());
            adminVo.setAvatar(admin.getUsername());
            String roleIds = admin.getRoleIds();
            ObjectMapper objectMapper = new ObjectMapper();
            Integer[] integers = objectMapper.readValue(roleIds, Integer[].class);
            adminVo.setRoleIds(integers);
            adminVos.add(adminVo);
        }

        ListBean listBean = new ListBean();
        listBean.setItems(adminVos);
        listBean.setTotal(total);

        return listBean;
    }

    @Override
    public void deleteAdminById(AdminVo adminVo) {
        int id = adminVo.getId();
        adminMapper.deleteAdminById(id);

    }

    @Override
    public AddAdminVo insertAdmin(AddAdminVo addAdminVo) {
        Date date = new Date();
        addAdminVo.setAddTime(date);
        addAdminVo.setUpdateTime(date);
        adminMapper.insertAdmin(addAdminVo);
        String username = addAdminVo.getUsername();
        int i = adminMapper.selectIdByUsername(username);
        addAdminVo.setId(i);
        return addAdminVo;
    }

    @Override
    public AddAdminVo updateAdminById(AddAdminVo addAdminVo) {
        Date date = new Date();
        addAdminVo.setUpdateTime(date);
        adminMapper.updateAdminById(addAdminVo);
        return addAdminVo;
    }

}
