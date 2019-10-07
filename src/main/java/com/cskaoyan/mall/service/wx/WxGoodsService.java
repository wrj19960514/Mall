package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Goods;

import java.util.List;
import java.util.Map;

public interface WxGoodsService {
    long count();
    List<Goods> getRelatedGoods(int id);
    Map<String, Object> getCategory(int id);
    List<Goods> getGoodsList(int categoryId, int page, int size);
    void getGoodsDetail(int id);
}
