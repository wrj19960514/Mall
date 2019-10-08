package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponExample;
import java.util.List;

import com.cskaoyan.mall.vo.promote.Creator;
import org.apache.ibatis.annotations.Param;

public interface GrouponMapper {
    long countByExample(GrouponExample example);

    int deleteByExample(GrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    List<Groupon> selectByExample(GrouponExample example);

    Groupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByExample(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    List<Groupon> queryCreatorGroupons(@Param("userId")Integer userId);

    List<Groupon> queryJoinerGroupons(@Param("userId")Integer userId);

    List<Creator> queryAllJoiner(@Param("grouponId") int grouponId);
}