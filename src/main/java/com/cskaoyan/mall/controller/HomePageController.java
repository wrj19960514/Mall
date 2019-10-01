package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.HomePageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomePageController {

    @Autowired
    HomePageService homePageService;

    @RequestMapping(value = "/admin/dashboard",method = RequestMethod.GET)
    public BaseRespVo getDashboard(){
        Map<String,Integer> total = homePageService.getDashboard();
        return BaseRespVo.ok(total);
    }
}
