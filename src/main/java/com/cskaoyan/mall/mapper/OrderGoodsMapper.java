package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.OrderGoodsExample;
import java.util.List;

import com.cskaoyan.mall.vo.Statement.GoodsStat;
import com.cskaoyan.mall.vo.Statement.OrderStat;
import com.cskaoyan.mall.vo.promote.OrderGood;
import org.apache.ibatis.annotations.Param;

public interface OrderGoodsMapper {
    long countByExample(OrderGoodsExample example);

    int deleteByExample(OrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsExample example);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    List<GoodsStat> getGoodsStatement();

    List<OrderGood> selectOrderGoodList(@Param("orderId") Integer orderId);
}