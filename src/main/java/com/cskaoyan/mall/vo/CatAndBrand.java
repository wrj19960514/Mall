package com.cskaoyan.mall.vo;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Category;

import java.util.List;

/**
 * @author adore
 * @date 2019/9/30 17:54
 */
public class CatAndBrand {
    List<Label> brandList;
    List<CategoryList> categoryList;

    public List<Label> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Label> brandList) {
        this.brandList = brandList;
    }

    public List<CategoryList> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryList> categoryList) {
        this.categoryList = categoryList;
    }
}
