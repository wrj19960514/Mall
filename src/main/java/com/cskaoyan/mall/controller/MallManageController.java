package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MallManageController {
    @RequestMapping("/admin/region")
    public BaseRespVo region() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/brand")
    public BaseRespVo brand() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/category")
    public BaseRespVo category() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/order")
    public BaseRespVo order() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/issue")
    public BaseRespVo issue() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/keyword")
    public BaseRespVo keyword() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }
}
