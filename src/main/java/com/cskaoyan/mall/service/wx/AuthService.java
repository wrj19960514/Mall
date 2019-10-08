package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.wx.RegisterVo;

public interface AuthService {
    boolean register(RegisterVo registerVo);
}
