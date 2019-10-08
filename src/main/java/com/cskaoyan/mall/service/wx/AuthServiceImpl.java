package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.wx.RegisterVo;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Override
    public boolean register(RegisterVo registerVo) {
        return false;
    }
}
