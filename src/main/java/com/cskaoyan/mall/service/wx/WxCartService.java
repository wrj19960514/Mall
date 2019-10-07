package com.cskaoyan.mall.service.wx;


import com.cskaoyan.mall.vo.wx.*;

import java.math.BigDecimal;

public interface WxCartService {

    boolean updateCart(WxCartUpdateVo wxCartUpdateVo);

    Boolean deleteCart(WxCartDeleteVo wxCartDeleteVo);

    WxCartListVo getIndex();

    long addCart(WxCartAddVo wxCartAddVo);

    long fastAddCart(WxCartAddVo wxCartAddVo);

    void checkOut(int cartId, int addressId, int couponId, int grouponRulesId);

    BigDecimal goodsCount();

    boolean checked(WxCartCheckedVo wxCartCheckedVo);

    CartCheckOutRespVo checkOut(CartCheckOutVo cartCheckOutVo);
}
