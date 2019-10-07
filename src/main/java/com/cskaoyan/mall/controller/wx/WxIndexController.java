package com.cskaoyan.mall.controller.wx;
import com.cskaoyan.mall.service.wx.WxIndexService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.wx.WxOrderstateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WxIndexController {

    @Autowired
    WxIndexService wxIndexService;

    @RequestMapping("/wx/user/index")
    public BaseRespVo userIndex(){
       WxOrderstateVo wxOrderstateVo = wxIndexService.getuserIndex();
       return BaseRespVo.ok(wxOrderstateVo);
    }

    @RequestMapping("/wx/home/index")
    public BaseRespVo homeIndex(){
        Map<String,Object> map = wxIndexService.gethomeIndex();
       return BaseRespVo.ok(map);
    }

    @RequestMapping("/wx/catalog/index")
    public BaseRespVo catalogIndex(){
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/wx/catalog/current")
    public BaseRespVo catalogCurrent(){
        return BaseRespVo.ok(null);
    }
}
