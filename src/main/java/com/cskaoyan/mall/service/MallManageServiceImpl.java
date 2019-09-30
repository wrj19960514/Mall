package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.vo.mallManage.RegionListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MallManageServiceImpl implements MallManageService {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public List getRegionList() {
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(11, 65);
        List<Region> regions = regionMapper.selectByExample(example);
        ArrayList<RegionListVo> regionListVos = new ArrayList<>();
        for (Region region : regions) {
            RegionListVo vo = new RegionListVo();
            vo.setCode(region.getCode());
            vo.setId(region.getId());
            vo.setType(region.getType());
            vo.setName(region.getName());
            vo.setChildren(getRegionList2(region.getCode()));
            regionListVos.add(vo);
        }
        return regionListVos;
    }

    private List getRegionList2(Integer code) {
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(code * 100, code * 100 + 99);
        List<Region> regions = regionMapper.selectByExample(example);
        ArrayList<RegionListVo> regionListVos = new ArrayList<>();
        for (Region region : regions) {
            RegionListVo vo = new RegionListVo();
            vo.setCode(region.getCode());
            vo.setId(region.getId());
            vo.setType(region.getType());
            vo.setName(region.getName());
            vo.setChildren(getRegionList3(region.getCode()));
            regionListVos.add(vo);
        }
        return regionListVos;
    }

    private List getRegionList3(Integer code) {
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(code * 100, code * 100 + 99);
        List<Region> regions = regionMapper.selectByExample(example);
        ArrayList<RegionListVo> regionListVos = new ArrayList<>();
        for (Region region : regions) {
            RegionListVo vo = new RegionListVo();
            vo.setCode(region.getCode());
            vo.setId(region.getId());
            vo.setType(region.getType());
            vo.setName(region.getName());
            regionListVos.add(vo);
        }
        return regionListVos;
    }
}
