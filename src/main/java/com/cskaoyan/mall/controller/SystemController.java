package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.LiteMall;
import com.cskaoyan.mall.service.SystemService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/config")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/mall",method = RequestMethod.GET)
    public BaseRespVo getMall(){
        Map<String,String> map = systemService.getMall();
        return BaseRespVo.ok(map);
    }

    @RequestMapping(value = "/mall",method = RequestMethod.POST)
    public BaseRespVo updateMall(@RequestBody LiteMall liteMall){
        System.out.println(liteMall);
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        flag = systemService.updateMall(liteMall);
        if(flag = true){
            return  BaseRespVo.ok(null);
        }else{
            return  BaseRespVo.error(null);
        }
    }

    @RequestMapping(value = "/express",method = RequestMethod.GET)
    public BaseRespVo getExpress(){
        Map<String,String> map = systemService. getExpress();
        return BaseRespVo.ok(map);
    }

    @RequestMapping(value = "/express",method = RequestMethod.POST)
    public BaseRespVo updateExpress(@RequestBody LiteMall liteMall){
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        flag = systemService.updateExpress(liteMall);
        if(flag = true){
            return BaseRespVo.ok(null);
        }else{
            return BaseRespVo.error(null);
        }
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public BaseRespVo getOrder(){
        Map<String,String> map = systemService.getOrder();
        return BaseRespVo.ok(map);
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public BaseRespVo updateOrder(@RequestBody LiteMall liteMall){
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        flag = systemService.updateOrder(liteMall);
        if(flag = true){
            return BaseRespVo.ok(null);
        }else{
            return BaseRespVo.error(null);
        }
    }


    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public BaseRespVo getWx(){
        Map<String,String> map = systemService.getWx();
        return BaseRespVo.ok(map);
    }

    @RequestMapping(value = "/wx",method = RequestMethod.POST)
    public BaseRespVo updateWx(@RequestBody LiteMall liteMall){
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        flag = systemService.updateWx(liteMall);
        if(flag = true){
            return BaseRespVo.ok(null);
        }else{
            return BaseRespVo.error(null);
        }
    }
}
