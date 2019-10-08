package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.WxCartService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.wx.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("wx/cart")
public class WxCartController {

    @Autowired
    WxCartService wxCartService;

    @RequestMapping("index")
    public BaseRespVo index() {
        WxCartListVo index = wxCartService.getIndex();
        return BaseRespVo.ok(index);
    }

    @RequestMapping("add")
    public BaseRespVo add(@RequestBody WxCartAddVo wxCartAddVo) {
        long cartTotal = wxCartService.addCart(wxCartAddVo);
        if (cartTotal != -1) {
            return BaseRespVo.ok(cartTotal);
        } else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("fastadd")
    public BaseRespVo fasstAddCart(@RequestBody WxCartAddVo wxCartAddVo) {
        long cartTotal = wxCartService.fastAddCart(wxCartAddVo);
        if (cartTotal != -1) {
            return BaseRespVo.ok(cartTotal);
        } else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody WxCartUpdateVo wxCartUpdateVo) {
        boolean update = wxCartService.updateCart(wxCartUpdateVo);
        if (update) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody WxCartDeleteVo wxCartDeleteVo) {
        Boolean deleteCart = wxCartService.deleteCart(wxCartDeleteVo);
        if (deleteCart) {
            WxCartListVo index = wxCartService.getIndex();
            return BaseRespVo.ok(index);
        }
        return BaseRespVo.error("系统错误");
    }

    @RequestMapping("checked")
    public BaseRespVo checked(@RequestBody WxCartCheckedVo wxCartCheckedVo) {
        wxCartService.checked(wxCartCheckedVo);
        WxCartListVo index = wxCartService.getIndex();
        return BaseRespVo.ok(index);
    }

    @RequestMapping("goodscount")
    public BaseRespVo goodsCount() {
        BigDecimal goodsCount = wxCartService.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }

    @RequestMapping("checkout")
    public BaseRespVo checkout(CartCheckOutVo cartCheckOutVo) {
        CartCheckOutRespVo checkOutRespVo = wxCartService.checkOut(cartCheckOutVo);
        return BaseRespVo.ok(checkOutRespVo);
    }
}
