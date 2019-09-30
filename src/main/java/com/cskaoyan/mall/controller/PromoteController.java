package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.PromoteService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoteController {

    @Autowired
    PromoteService promoteService;

    @RequestMapping("admin/ad/list")
    public BaseRespVo getAdList(int pag, int limit, String sort, String order) {
        ListBean adList = promoteService.getAdList(pag, limit, sort, order);
        BaseRespVo ok = BaseRespVo.ok(adList);
        return ok;
    }
}
