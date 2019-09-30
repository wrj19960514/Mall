package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.BrandExample;
import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.RegionListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MallManageServiceImpl implements MallManageService {
    @Autowired
    RegionMapper regionMapper;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List getRegionList(int i, int i2) {
        if (i > 700000) {
            return null;
        }
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(i, i2);
        List<Region> regions = regionMapper.selectByExample(example);
        ArrayList<RegionListVo> regionListVos = new ArrayList<>();
        for (Region region : regions) {
            Integer lowNum = region.getCode();
            RegionListVo vo = new RegionListVo();
            vo.setCode(region.getCode());
            vo.setId(region.getId());
            vo.setType(region.getType());
            vo.setName(region.getName());
            vo.setChildren(getRegionList(lowNum * 100, lowNum * 100 + 99));
            regionListVos.add(vo);
        }
        return regionListVos;
    }

    @Override
    public List getBrandList(BrandInfoVo brandInfoVo) {
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        if (brandInfoVo.getId() != 0) {
            criteria.andIdEqualTo(brandInfoVo.getId());
        }
        if (brandInfoVo.getName() != null) {
            criteria.andNameLike(brandInfoVo.getName());
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public void deleteBrand(Integer id, Boolean deleted) {
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Brand> brands = brandMapper.selectByExample(example);
        for (Brand brand : brands) {
            brand.setDeleted(true);
            brandMapper.updateByExample(brand,example);
        }
    }

    @Override
    public void createBrand(BrandCreateVo brandCreateVo) {
        Brand brand = new Brand();
        brand.setName(brandCreateVo.getName());
        brand.setDesc(brandCreateVo.getDesc());
        brand.setPicUrl(""); // TODO
        brand.setFloorPrice(brand.getFloorPrice());
        brand.setAddTime(new Date());
        brand.setDeleted(false);
        brandMapper.insert(brand);
    }
}
