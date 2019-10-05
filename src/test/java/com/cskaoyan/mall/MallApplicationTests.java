package com.cskaoyan.mall;

import com.cskaoyan.mall.bean.OrderHandleOptions;
import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.OrderHandleOptionsMapper;
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
    OrderHandleOptionsMapper mapper;

    /**
     * 测试*MapperExample，使用前在*Mapper注册组件
     */
    @Test
    public void contextLoads() {
        mapper.updateCancelByOrderId(2,true);
        mapper.updateCommentlByOrderId(2,true);
        mapper.updateConfirmByOrderId(2,true);
        mapper.updateDeleteByOrderId(2,true);
        mapper.updatePayByOrderId(2,true);
        mapper.updateRebuyByOrderId(2,true);
        mapper.updateRefundByOrderId(2,true);
        OrderHandleOptions record = mapper.queryRecordByOrderId(2);
        System.out.println("record = " + record);
    }

}
