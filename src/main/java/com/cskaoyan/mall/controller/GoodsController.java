package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.util.ParamUtils;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.goodsManage.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adore
 * @date 2019/9/30 14:33
 */
@RestController
@RequestMapping("/admin")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/list")
    public BaseRespVo getGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        // 不为空且不是数字
        if (!ParamUtils.isEmpty(goodsSn) && !ParamUtils.isInteger(goodsSn)) {
            return BaseRespVo.error(null);
        }
        ListBean goods = goodsService.getGoodsList(page, limit, sort, order, goodsSn, name);
        return BaseRespVo.ok(goods);
    }

    @RequestMapping("/goods/catAndBrand")
    public BaseRespVo catAndBrand() {
        CatAndBrand catAndBrand = goodsService.catAndBrand();
        return BaseRespVo.ok(catAndBrand);
    }

    @RequestMapping("/goods/delete")
    public BaseRespVo delete(@RequestBody Goods goods) {
        boolean delete = goodsService.delete(goods);
        if (delete) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.error(null);
    }

    @RequestMapping("/goods/create")
    public BaseRespVo create(@RequestBody GoodsVo goodsVo) {
        return goodsService.create(goodsVo);
    }

    @RequestMapping("/goods/detail")
    public BaseRespVo detail(int id) {
        GoodsVo goodsVo = goodsService.detail(id);
        return BaseRespVo.ok(goodsVo);
    }

    @RequestMapping("/goods/update")
    public BaseRespVo update(@RequestBody GoodsVo goodsVo) {
        return goodsService.update(goodsVo);
    }

    @RequestMapping("/comment/list")
    public BaseRespVo commentList(int page, int limit, String sort, String order, String userId, String valueId) {
        // 不为空且不是数字
        if (!ParamUtils.isEmpty(userId) && !ParamUtils.isInteger(userId)) {
            return BaseRespVo.error(null);
        }
        if (!ParamUtils.isEmpty(valueId) && !ParamUtils.isInteger(valueId)) {
            return BaseRespVo.error(null);
        }
        ListBean comments = goodsService.commentList(page, limit, sort, order, userId, valueId);
        return BaseRespVo.ok(comments);
    }

    @RequestMapping("/comment/delete")
    public BaseRespVo deleteComment(@RequestBody Comment comment) {
        boolean delete = goodsService.deleteComment(comment);
        if (delete) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.error(null);
    }
}


