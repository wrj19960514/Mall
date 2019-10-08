package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsByCategory;
import com.cskaoyan.mall.vo.wx.WxGoodsDetailVo;

import java.util.List;
import java.util.Map;

public interface WxGoodsService {
    long count();
    List<Goods> getRelatedGoods(int id);
    Map<String, Object> getCategory(int id);

    WxGoodsDetailVo getGoodsDetail(int id);

    GoodsByCategory getGoodsListByBrand(Integer brandId, int page, int size);

    GoodsByCategory getGoodsList(int categoryId, int page, int size);
}
