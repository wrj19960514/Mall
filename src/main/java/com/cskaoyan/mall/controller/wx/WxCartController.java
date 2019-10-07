package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.WxCartService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.wx.WxCartAddVo;
import com.cskaoyan.mall.vo.wx.WxCartCheckedVo;
import com.cskaoyan.mall.vo.wx.WxCartDeleteVo;
import com.cskaoyan.mall.vo.wx.WxCartListVo;
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
        boolean addCart = wxCartService.addCart(wxCartAddVo);
        if (addCart) {
            return BaseRespVo.ok(null);
        } else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("fastadd")
    public BaseRespVo fasstAddCart(@RequestBody WxCartAddVo wxCartAddVo) {
        boolean fastAddCart = wxCartService.fastAddCart(wxCartAddVo);
        if (fastAddCart) {
            return BaseRespVo.ok(null);
        } else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("update")
    public BaseRespVo update(int goodsId, int productId, int number, int id) {
        boolean update = wxCartService.updateCart(goodsId, productId, number, id);
        if (update) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody WxCartDeleteVo wxCartDeleteVo) {
        wxCartService.deleteCart(wxCartDeleteVo);
        WxCartListVo index = wxCartService.getIndex();
        return BaseRespVo.ok(index);
    }

    @RequestMapping("checked")
    public BaseRespVo checked(@RequestBody WxCartCheckedVo wxCartCheckedVo) {
        boolean checked = wxCartService.checked(wxCartCheckedVo);
        if (checked) {
            return BaseRespVo.ok(null);
        } else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("goodscount")
    public BaseRespVo goodsCount() {
        BigDecimal goodsCount = wxCartService.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }

//    @RequestMapping("checkout")
//    public BaseRespVo checkout(int cartId, int addressId, int couponId, int grouponRulesId) {
//        wxCartService.checkOut(cartId, addressId, couponId, grouponRulesId);
//        return
//    }

}
