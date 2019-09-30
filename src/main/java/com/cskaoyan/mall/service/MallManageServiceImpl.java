package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
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
        System.out.println("regions = " + regions);
        return regions;
    }
}
