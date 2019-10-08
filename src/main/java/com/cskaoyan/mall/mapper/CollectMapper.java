package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.CollectExample;

import java.util.List;

import com.cskaoyan.mall.vo.collectManage.collectAndGood;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<collectAndGood> queryCollectList(@Param("type") Integer type);

    Collect queryCollectByValueId(@Param("typeId") Integer typeId);

    void delectCollectByValueId(@Param("typeId") Integer typeId);

    void insertCollect(@Param("collect") Collect collect);
}