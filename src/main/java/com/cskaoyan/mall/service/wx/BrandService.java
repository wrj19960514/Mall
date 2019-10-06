package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Brand;

import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 18:40
 */
public interface BrandService {
    Map getBrandList(int page, int size);

    Brand getBrandDetail(int id);
}
