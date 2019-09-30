package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 14:41
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public ListBean getGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        // 根据sort的字段,升序或降序排列
        goodsExample.setOrderByClause(sort+ " " + order);
        // 商品id精确查询
        if (goodsSn != null && !("".equals(goodsSn.trim())) ) {
            goodsExample.createCriteria().andGoodsSnEqualTo(goodsSn);
        }
        // 商品名称模糊查询
        if (name != null && !("".equals(name.trim()))) {
            goodsExample.createCriteria().andNameLike("%" + name + "%");
        }
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo<Goods> userPageInfo = new PageInfo<>(goods);
        long total = userPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(goods);
        listBean.setTotal(total);
        return listBean;
    }
}
