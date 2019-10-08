package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.OrderHandleOptions;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderHandleOptionsMapper {

    @Select("SELECT order_id, cancel, comment, confirm, `delete`, pay, rebuy, refund FROM " +
            "cskaoyan_mall_order_handleOption WHERE order_id = #{order_id}")
    OrderHandleOptions queryRecordByOrderId(@Param("order_id") int id);

    @Update("INSERT INTO cskaoyan_mall_order_handleOption(order_id, cancel, comment, confirm, " +
            "`delete`, pay, rebuy, refund) VALUE(#{order_id}, 0, 0, 0, 0, 0, 0, 0)")
    int insertRecord(@Param("order_id") int orderId);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET cancel = #{cancel} WHERE order_id = #{order_id}")
    int updateCancelByOrderId(@Param("order_id")int orderId, @Param("cancel")boolean cancel);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET comment = #{comment} WHERE order_id = #{order_id}")
    int updateCommentByOrderId(@Param("order_id")int orderId, @Param("comment")boolean comment);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET confirm = #{confirm} WHERE order_id = #{order_id}")
    int updateConfirmByOrderId(@Param("order_id")int orderId, @Param("confirm")boolean confirm);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET `delete` = #{delete} WHERE order_id = #{order_id}")
    int updateDeleteByOrderId(@Param("order_id")int orderId, @Param("delete")boolean delete);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET pay = #{pay} WHERE order_id = #{order_id}")
    int updatePayByOrderId(@Param("order_id")int orderId, @Param("pay")boolean pay);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET rebuy = #{rebuy} WHERE order_id = #{order_id}")
    int updateRebuyByOrderId(@Param("order_id")int orderId, @Param("rebuy")boolean rebuy);

    @Update("UPDATE cskaoyan_mall_order_handleOption SET refund = #{refund} WHERE order_id = #{order_id}")
    int updateRefundByOrderId(@Param("order_id")int orderId, @Param("refund")boolean refund);
}
