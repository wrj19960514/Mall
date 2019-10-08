package com.cskaoyan.mall.service.wx;


import com.cskaoyan.mall.vo.wx.*;

import java.math.BigDecimal;

public interface WxCartService {

    boolean updateCart(WxCartUpdateVo wxCartUpdateVo);

    Boolean deleteCart(WxCartDeleteVo wxCartDeleteVo);

    WxCartListVo getIndex();

    boolean addCart(WxCartAddVo wxCartAddVo);

    int fastAddCart(WxCartAddVo wxCartAddVo);

    WxCartCheckoutReturnVo checkOut(WxCartCheckOutVo wxCartCheckOutVo);

    BigDecimal goodsCount();

    boolean checked(WxCartCheckedVo wxCartCheckedVo);
}
