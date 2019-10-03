package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.bean.StorageExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

  /*  List<Storage> queryAllStorage(@Param("sort") String sort, @Param("order") String order);

    List<Storage> queryStorageByKeyAndName(@Param("sort") String sort, @Param("order") String order, @Param("key") String key, @Param("name") String name);

    void updateStorage(@Param("storage") Storage storage);

    void deleteStorage(@Param("id") Integer id);*/
}