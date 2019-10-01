package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.service.PromoteService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/ad")
public class PromoteController {

    @Autowired
    PromoteService promoteService;

    @RequestMapping("/list")
    public BaseRespVo getAdList(int page, int limit, String sort, String order, String name, String content) {
        ListBean adList = promoteService.getAdList(page, limit, sort, order, name, content);
        BaseRespVo ok = BaseRespVo.ok(adList);
        return ok;
    }

    @RequestMapping("/update")
    public BaseRespVo updateAds(@RequestBody Ad ad) {
        ad =  promoteService.updateAds(ad);
        BaseRespVo ok = BaseRespVo.ok(ad);
        return ok;
    }

    @RequestMapping("/delete")
    public BaseRespVo deleteAds(@RequestBody Ad ad) {
        promoteService.deleteAds(ad);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(null);
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }
}
