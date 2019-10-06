package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.wx.WxOrderstateVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public WxOrderstateVo getOrderstateForUser() {
        WxOrderstateVo wxOrderstateVo = new WxOrderstateVo();
        //
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        int userId = userMapper.queryUserIdByUsername(principal);
        //待付款
        OrderExample orderExample1 = new OrderExample();
        orderExample1.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)1);
        int unpaid = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnpaid(unpaid);
        //待发货
        OrderExample orderExample2 = new OrderExample();
        orderExample2.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)2);
        int unship = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnship(unship);
        //待收货
        OrderExample orderExample3 = new OrderExample();
        orderExample3.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)3);
        int unrecv = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnrecv(unrecv);
        //待评论
        OrderExample orderExample4 = new OrderExample();
        orderExample4.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)4);
        int uncomment = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUncomment(uncomment);
        return wxOrderstateVo;
    }
}
