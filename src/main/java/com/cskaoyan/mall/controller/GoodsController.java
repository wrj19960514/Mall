package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adore
 * @date 2019/9/30 14:33
 */
@RestController
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/list")
    public BaseRespVo getGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        ListBean goods = goodsService.getGoodsList(page, limit, sort, order, goodsSn, name);
        BaseRespVo ok = BaseRespVo.ok(goods);
        return ok;
    }

    @RequestMapping("/catAndBrand")
    public BaseRespVo catAndBrand() {
        CatAndBrand catAndBrand = goodsService.catAndBrand();
        BaseRespVo ok = BaseRespVo.ok(catAndBrand);
        return ok;
    }

    @RequestMapping("/delete")
    public BaseRespVo delete(@RequestBody Goods goods) {
        boolean delete = goodsService.delete(goods);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

//    @RequestMapping("/create")
//    public BaseRespVo create(@RequestBody ) {
//
//        BaseRespVo ok = BaseRespVo.ok(null);
//        return ok;
//    }
}


