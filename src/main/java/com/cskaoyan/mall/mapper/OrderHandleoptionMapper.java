package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.OrderHandleoption;
import com.cskaoyan.mall.bean.OrderHandleoptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderHandleoptionMapper {
    long countByExample(OrderHandleoptionExample example);

    int deleteByExample(OrderHandleoptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderHandleoption record);

    int insertSelective(OrderHandleoption record);

    List<OrderHandleoption> selectByExample(OrderHandleoptionExample example);

    OrderHandleoption selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderHandleoption record, @Param("example") OrderHandleoptionExample example);

    int updateByExample(@Param("record") OrderHandleoption record, @Param("example") OrderHandleoptionExample example);

    int updateByPrimaryKeySelective(OrderHandleoption record);

    int updateByPrimaryKey(OrderHandleoption record);
}