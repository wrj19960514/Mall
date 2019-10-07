package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    SmsService smsService;

    @RequestMapping("message/send/{mobile}")
    public String sendMessage(@PathVariable("mobile") String mobile){
        int code = (int) ((Math.random()*9+1)*100000);
        //boolean b = smsService.sendMessage(mobile, code + "");
        //session.put("code",code+"");
        //return b?"ok":"fail";
        return "";
    }
}
