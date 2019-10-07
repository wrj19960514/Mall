package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GoodsAttribute;
import com.cskaoyan.mall.bean.GoodsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttributeMapper {
    long countByExample(GoodsAttributeExample example);

    int deleteByExample(GoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    List<GoodsAttribute> selectByExample(GoodsAttributeExample example);

    List<GoodsAttribute> selectAttributesByGoodsId(@Param("goodsId") int goodsId);

    GoodsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeExample example);

    int updateByExample(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeExample example);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);
}
