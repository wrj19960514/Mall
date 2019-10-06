package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.service.wx.BrandService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 18:25
 */
@RestController
@RequestMapping("wx/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @RequestMapping("list")
    public BaseRespVo getBrandList(int page, int size) {
        Map map = brandService.getBrandList(page, size);
        return BaseRespVo.ok(map);
    }

    @RequestMapping("detail")
    public BaseRespVo getBrandDetail(int id) {
        Brand brand = brandService.getBrandDetail(id);
        Map<Object, Object> map = new HashMap<>();
        map.put("brand", brand);
        return BaseRespVo.ok(map);
    }
}
