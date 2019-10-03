package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.vo.goodsManage.CatAndBrand;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.goodsManage.GoodsVo;


/**
 * @author adore
 * @date 2019/9/30 14:40
 */
public interface GoodsService {
    /**获取商品列表
     * @param page 当前页
     * @param limit 页面条目数
     * @param sort 排序字段
     * @param order 升序/降序
     * @param goodsSn 搜索的商品编号
     * @param name 搜索的商品名称
     * @return 商品列表
     */
    ListBean getGoodsList(int page, int limit, String sort, String order, String goodsSn, String name);

    /**添加商品时, 获取商品类型和生产商
     * @return 类型和生产商
     */
    CatAndBrand catAndBrand();

    /** 删除商品
     * @param goods 商品
     * @return boolean
     */
    boolean delete(Goods goods);

    /**获取评论列表
     * @param page 当前页
     * @param limit 页面条目数
     * @param sort 排序字段
     * @param order 升序/降序
     * @param userId 搜索的用户id
     * @param valueId 搜索的商品id
     * @return 评论列表
     */
    ListBean commentList(int page, int limit, String sort, String order, String userId, String valueId);

    /**
     * 删除评论
     * @param comment 要删除的评论
     * @return boolean
     */
    boolean deleteComment(Comment comment);

    /**添加商品
     * @param goodsVo 商品信息封装
     * @return boolean
     */
    boolean create(GoodsVo goodsVo);

    /**
     * 编辑商品前获取商品详情
     * @param id id
     * @return 商品所有信息
     */
    GoodsVo detail(int id);
}
