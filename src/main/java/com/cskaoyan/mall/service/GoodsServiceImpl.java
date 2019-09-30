package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.mapper.CommentMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.goodsManage.CategoryList;
import com.cskaoyan.mall.vo.goodsManage.Label;
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
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CommentMapper commentMapper;
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

    @Override
    public CatAndBrand catAndBrand() {
        List<CategoryList> categoryList = categoryMapper.queryCategoryLabel();
        for (CategoryList categories : categoryList) {
            String id = categories.getValue();
            List<Label> children = categoryMapper.queryCategoryChildren(id);
            categories.setChildren(children);
        }
        List<Label> brands = brandMapper.queryBrandLabel();
        CatAndBrand catAndBrand = new CatAndBrand();
        catAndBrand.setBrandList(brands);
        catAndBrand.setCategoryList(categoryList);
        return catAndBrand;
    }

    @Override
    public boolean delete(Goods goods) {
        int i = goodsMapper.deleteByPrimaryKey(goods.getId());
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public ListBean commentList(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page, limit);
        CommentExample commentExample = new CommentExample();
        // 根据sort的字段,升序或降序排列
        commentExample.setOrderByClause(sort+ " " + order);
        // 用户id精确查询
        if (userId != null && !("".equals(userId.trim())) ) {
            commentExample.createCriteria().andUserIdEqualTo(Integer.valueOf(userId));
        }
        // 商品id精准查询
        if (valueId != null && !("".equals(valueId.trim()))) {
            commentExample.createCriteria().andValueIdEqualTo(Integer.valueOf(valueId));
        }
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> userPageInfo = new PageInfo<>(comments);
        long total = userPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(comments);
        listBean.setTotal(total);
        return listBean;
    }
}
