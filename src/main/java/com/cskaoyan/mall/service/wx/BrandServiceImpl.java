package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.BrandExample;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adore
 * @date 2019/10/6 18:42
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;
    @Override
    public Map getBrandList(int page, int size) {
        PageHelper.startPage(page, size);
        BrandExample brandExample = new BrandExample();
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        long total = brandPageInfo.getTotal();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("brandList", brands);
        map.put("totalPages", total);
        return map;
    }

    @Override
    public Brand getBrandDetail(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
