package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.RoleExample;

import java.util.List;

import com.cskaoyan.mall.vo.adminManage.RoleVo;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleVo> queryAllRoles();

    List<Role> selectAllRoles(@Param("sort") String sort, @Param("order") String order);

    List<Role> selectRolesByName(@Param("name") String name, @Param("sort") String sort, @Param("order") String order);

    void insertRole(@Param("role") Role role);

    Integer queryIdByName(@Param("name") String name);

    void updateRole(@Param("role") Role role);

    void deleteRole(@Param("id") Integer id);

    List<String> queryRoleNameByRoleIds(@Param("roleIds") Integer[] roleIds);
}