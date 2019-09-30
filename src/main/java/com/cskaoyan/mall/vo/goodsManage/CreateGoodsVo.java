package com.cskaoyan.mall.vo.goodsManage;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsAttribute;
import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.GoodsSpecification;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 23:50
 */
public class CreateGoodsVo {
    Goods goods;
    List<GoodsAttribute> attributes;
    List<GoodsProduct> products;
    List<GoodsSpecification> specifications;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<GoodsProduct> getProducts() {
        return products;
    }

    public void setProducts(List<GoodsProduct> products) {
        this.products = products;
    }

    public List<GoodsSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<GoodsSpecification> specifications) {
        this.specifications = specifications;
    }
}
