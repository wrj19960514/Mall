package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminExample;

import java.util.List;

import com.cskaoyan.mall.vo.RoleIdsVo;
import com.cskaoyan.mall.vo.adminManage.AddAdminVo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> queryAllAdmin(@Param("sort") String sort, @Param("order") String order);

    List<Admin> queryAdminsByUsername(@Param("sort") String sort, @Param("order") String order, String username);

    void deleteAdminById(@Param("id") int id);

    void insertAdmin(@Param("addAdminVo") AddAdminVo addAdminVo);

    int selectIdByUsername(@Param("username") String username);

    void updateAdminById(@Param("addAdminVo") AddAdminVo addAdminVo);

    String queryPasswordByUsername(@Param("principal") String principal);

    RoleIdsVo queryRoleIdsByUsername(@Param("principal") String principal);
}