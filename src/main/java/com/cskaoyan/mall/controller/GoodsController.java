package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.goodsManage.CreateGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // 有字母
        if (goodsSn != null && goodsSn.matches("(?i)[^a-z]*[a-z]+[^a-z]*")) {
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

    @RequestMapping("/create")
    public BaseRespVo create(@RequestBody CreateGoodsVo createGoodsVo) {
        System.out.println(createGoodsVo);
        boolean create = goodsService.create(createGoodsVo);
        if (create) {
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.error(null);
    }

    @RequestMapping("/comment/list")
    public BaseRespVo commentList(int page, int limit, String sort, String order, String userId, String valueId) {
        // 有字母
        if (userId != null && userId.matches("(?i)[^a-z]*[a-z]+[^a-z]*")) {
            return BaseRespVo.error(null);
        }
        if (valueId != null && valueId.matches("(?i)[^a-z]*[a-z]+[^a-z]*")) {
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


