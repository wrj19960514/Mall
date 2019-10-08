package com.cskaoyan.mall.service.wx;


import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.wx.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;


@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(RegisterVo registerVo) {
        User user = new User();
        Date date = new Date(System.currentTimeMillis());
        user.setUsername(registerVo.getUsername());
        user.setPassword(registerVo.getPassword());
        user.setMobile(registerVo.getMobile());
        user.setAddTime(date);
        user.setGender((byte)1);
        user.setNickname(registerVo.getUsername());
        user.setWeixinOpenid(registerVo.getWxCode());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(registerVo.getUsername());
        int count = (int)userMapper.countByExample(userExample);
        if(count == 0){
            int insert = userMapper.insert(user);
            if(insert == 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean reset(RegisterVo registerVo) {
        User user = new User();
        user.setPassword(registerVo.getPassword());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andMobileEqualTo(registerVo.getMobile());
        int update = userMapper.updateByExample(user,userExample);
        if(update == 1){
            return true;
        }
        return false;
    }
}
