package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.SmsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

@RestController
public class SmsController {

    @Autowired
    SmsService smsService;

    @RequestMapping("message/send/{mobile}")
    public String sendMessage(@PathVariable("mobile") String mobile){
        int code = (int) ((Math.random()*9+1)*100000);
        //Session session = SecurityUtils.getSubject().getSession();
        //boolean b = smsService.sendMessage(mobile, code + "");
        //session.setAttribute("code",code+"");
        //return b?"ok":"fail";
        return "";
    }
}
