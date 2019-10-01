package com.cskaoyan.mall.mapper;

import org.apache.ibatis.annotations.Param;


public interface LiteMallMapper {

    String getSystemMessage(@Param("id") int id);

    boolean updateSystemMessage(@Param("keyName")String keyName,@Param("keyValue")String keyValue,@Param("updateDate")String updateDate);

}
