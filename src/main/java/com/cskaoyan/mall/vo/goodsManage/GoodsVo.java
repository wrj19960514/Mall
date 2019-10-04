package com.cskaoyan.mall.vo.goodsManage;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsAttribute;
import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.GoodsSpecification;

import javax.validation.Valid;
import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 23:50
 */
public class GoodsVo {
    @Valid
    Goods goods;
    @Valid
    List<GoodsAttribute> attributes;
    @Valid
    List<GoodsProduct> products;
    @Valid
    List<GoodsSpecification> specifications;
    Integer[] categoryIds;

    public Integer[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Integer[] categoryIds) {
        this.categoryIds = categoryIds;
    }

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

    @Override
    public String toString() {
        return "GoodsVo{" +
                "goods=" + goods +
                ", attributes=" + attributes +
                ", products=" + products +
                ", specifications=" + specifications +
                '}';
    }
}
