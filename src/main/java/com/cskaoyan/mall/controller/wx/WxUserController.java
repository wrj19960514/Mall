package com.cskaoyan.mall.controller.wx;


import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.pc.UserService;
import com.cskaoyan.mall.service.wx.WxUserService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.wx.WxOrderstateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/user")
public class WxUserController {

    @Autowired
    WxUserService wxUserService;

    @RequestMapping("/index")
    public BaseRespVo index(){
       WxOrderstateVo wxOrderstateVo = wxUserService.getOrderstateForUser();
        return BaseRespVo.ok(wxOrderstateVo);
    }
}
