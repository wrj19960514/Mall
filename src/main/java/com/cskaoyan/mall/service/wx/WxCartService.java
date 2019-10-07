package com.cskaoyan.mall.service.wx;


import com.cskaoyan.mall.vo.wx.WxCartAddVo;
import com.cskaoyan.mall.vo.wx.WxCartCheckedVo;
import com.cskaoyan.mall.vo.wx.WxCartDeleteVo;
import com.cskaoyan.mall.vo.wx.WxCartListVo;

import java.math.BigDecimal;
import java.util.Map;

public interface WxCartService {

    boolean updateCart(int goodsId, int productId, int number, int id);

    void deleteCart(WxCartDeleteVo wxCartDeleteVo);

    WxCartListVo getIndex();

    boolean addCart(WxCartAddVo wxCartAddVo);

    boolean fastAddCart(WxCartAddVo wxCartAddVo);

    void checkOut(int cartId, int addressId, int couponId, int grouponRulesId);

    BigDecimal goodsCount();

    boolean checked(WxCartCheckedVo wxCartCheckedVo);
}
