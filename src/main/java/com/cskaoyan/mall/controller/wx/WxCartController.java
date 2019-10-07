package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.WxCartService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class WxCartController {

    @Autowired
    WxCartService wxCartService;

//    @RequestMapping("index")
//    public BaseRespVo index() {
//        wxCartService.getIndex();
//        return BaseRespVo.ok();
//    }

//    @RequestMapping("add")
//    public BaseRespVo add(int goodsId, int productId, int number) {
//
//    }
//
//    @RequestMapping("fastadd")

    @RequestMapping("update")
    public BaseRespVo update(int goodsId, int productId, int number, int id) {
        boolean update = wxCartService.updateCart(goodsId, productId, number, id);
        if (update) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }

    @RequestMapping("delete")
    public BaseRespVo delete(int[] productIds) {
        wxCartService.deleteCart(productIds);
        return BaseRespVo.ok(null);
    }

//    @RequestMapping("checked")
//
//    @RequestMapping("goodscount")
//
//    @RequestMapping("checkout")

}
