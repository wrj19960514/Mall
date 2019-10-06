package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.wx.WxOrderstateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public WxOrderstateVo getOrderstateForUser(String username) {
        //查询用户id
        WxOrderstateVo wxOrderstateVo = new WxOrderstateVo();
        int userId = userMapper.queryUserIdByUsername(username);
        //待付款
        OrderExample orderExample1 = new OrderExample();
        orderExample1.createCriteria().andOrderStatusEqualTo((short)1);
        int unpaid = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnpaid(unpaid);
        //待发货
        OrderExample orderExample2 = new OrderExample();
        orderExample2.createCriteria().andOrderStatusEqualTo((short)2);
        int unship = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnship(unship);
        //待收货
        OrderExample orderExample3 = new OrderExample();
        orderExample3.createCriteria().andOrderStatusEqualTo((short)3);
        int unrecv = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnship(unrecv);
        //待评论
        OrderExample orderExample4 = new OrderExample();
        orderExample4.createCriteria().andOrderStatusEqualTo((short)4);
        int uncomment = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUncomment(uncomment);
        return wxOrderstateVo;
    }
}
