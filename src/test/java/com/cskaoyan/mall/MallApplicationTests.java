package com.cskaoyan.mall;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @Autowired
    RegionMapper regionMapper;

    /**
     * 测试*MapperExample，使用前在*Mapper注册组件
     */
    @Test
    public void contextLoads() {
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andCodeBetween(1, 25);
        List<Region> regions = regionMapper.selectByExample(example);
        System.out.println("regions = " + regions);
    }

}
