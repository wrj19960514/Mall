package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.StatService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.Statement.StatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adore
 * @date 2019/10/1 17:08
 */
@RestController
@RequestMapping("/admin/stat")
public class StatController {
    @Autowired
    StatService statService;
    @RequestMapping("/user")
    public BaseRespVo userStatement() {
        StatVo statVo = statService.userStatement();
        return BaseRespVo.ok(statVo);
    }

    @RequestMapping("/order")
    public BaseRespVo orderStatement() {
        StatVo statVo = statService.orderStatement();
        return BaseRespVo.ok(statVo);
    }

    @RequestMapping("/goods")
    public BaseRespVo goodsStatement() {
        StatVo statVo = statService.goodsStatement();
        return BaseRespVo.ok(statVo);
    }
}
