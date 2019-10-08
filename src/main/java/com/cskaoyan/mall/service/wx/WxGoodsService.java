package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.vo.wx.WxGoodsDetailVo;

import java.util.List;
import java.util.Map;

public interface WxGoodsService {
    long count();
    List<Goods> getRelatedGoods(int id);
    Map<String, Object> getCategory(int id);
    List<Goods> getGoodsList(int categoryId, int page, int size);
    WxGoodsDetailVo getGoodsDetail(int id);

    List<Goods> getGoodsListByBrand(Integer brandId, int page, int size);
}
