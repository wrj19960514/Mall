package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryExample;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.vo.wx.WxGoodsDetailVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class WxGoodsServiceImpl implements WxGoodsService{

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public long count() {
        GoodsExample goodsExample = new GoodsExample();
        return goodsMapper.countByExample(goodsExample);
    }

    @Override
    public List<Goods> getRelatedGoods(int id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id); // 根据商品id查到category id
        Integer categoryId = goods.getCategoryId();
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId); // 根据category id 查询类别下所有商品
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        Iterator<Goods> iterator = goodsList.iterator();
        while (iterator.hasNext()) { // 去除本商品
            Goods next = iterator.next();
            if (next.getId().equals(id)) {
                iterator.remove();
            }
        }
        return goodsList;
    }

    @Override
    public Map<String, Object> getCategory(int id) {
        Map<String, Object> map = new HashMap<>();
        Category currentCategory = categoryMapper.selectByPrimaryKey(id);
        Integer pid = currentCategory.getPid();
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        CategoryExample categoryExample1 = new CategoryExample();
        CategoryExample.Criteria criteria1 = categoryExample1.createCriteria();
        if (pid == 0) { // 一级种类 查找pid == 该类id的子类
            criteria.andPidEqualTo(id);
            List<Category> currentSubCategory = categoryMapper.selectByExample(categoryExample);
            map.put("currentCategory", currentCategory);
            map.put("currentSubCategory", currentSubCategory);
        } else { // 二级种类
            criteria.andIdEqualTo(pid); // 根据pid查找id == pid的父类
            List<Category> parentCategory = categoryMapper.selectByExample(categoryExample);
            criteria1.andPidEqualTo(pid);// 查找其他类pid==该pid的brother类
            List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample1);
            map.put("brotherCategory", brotherCategory);
            map.put("currentCategory", currentCategory);
            map.put("parentCategory", parentCategory);
        }
        return map;
    }

    @Override
    public List<Goods> getGoodsList(int categoryId, int page, int size) {
        // 根据categoryId 查找商品pid == 该id的商品
        PageHelper.startPage(page, size);
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return goods;
    }

    @Override
    public void getGoodsDetail(int id) {
        WxGoodsDetailVo goodsDetailVo = new WxGoodsDetailVo();

    }

}
