package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsByCategory;
import com.cskaoyan.mall.service.wx.WxGoodsService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.wx.WxGoodsDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/goods")
public class WxGoodsController {

    @Autowired
    WxGoodsService wxGoodsService;

    @RequestMapping("count")
    public BaseRespVo count() {
        long goodsCount = wxGoodsService.count();
        Map<String, Long> data = new HashMap<>();
        data.put("goodsCount", goodsCount);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("list")
    public BaseRespVo getList(String brandId, String categoryId, int page, int size) {
        GoodsByCategory goodsList = null;
        if ("".equals(brandId) || brandId == null) {
            goodsList = wxGoodsService.getGoodsList(Integer.valueOf(categoryId), page, size);

        }
        if ("".equals(categoryId) || categoryId == null) {
            goodsList = wxGoodsService.getGoodsListByBrand(Integer.valueOf(brandId), page, size);
        }
        return BaseRespVo.ok(goodsList);
    }

    @RequestMapping("category")
    public BaseRespVo category(int id) {
        Map<String, Object> category = wxGoodsService.getCategory(id);
        return  BaseRespVo.ok(category);
    }

    @RequestMapping("detail")
    public BaseRespVo goodsDetail(int id) {
        WxGoodsDetailVo goodsDetail = wxGoodsService.getGoodsDetail(id);
        return BaseRespVo.ok(goodsDetail);
    }

    @RequestMapping("related")
    public BaseRespVo relatedGoods(int id) {
        List<Goods> relatedGoods = wxGoodsService.getRelatedGoods(id);
        return BaseRespVo.ok(relatedGoods);
    }

}
