package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public BaseRespVo getGoodsList(int page, int limit, String sort, String order) {
        ListBean goods = goodsService.getGoodsList(page, limit, sort, order);
        BaseRespVo ok = BaseRespVo.ok(goods);
        return ok;
    }
}


