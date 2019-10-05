package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.GrouponService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.WxListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adore
 * @date 2019/10/5 14:57
 */
@RestController
@RequestMapping("wx/groupon")
public class GrouponController {
    @Autowired
    GrouponService grouponService;

    @RequestMapping("list")
    public BaseRespVo getGrouponList(int page, int size) {
        WxListBean wxListBean = grouponService.getGrouponList(page,size);
        return BaseRespVo.ok(wxListBean);
    }

    @RequestMapping("my")
    public BaseRespVo myGroupon(int showType) {
        WxListBean wxListBean = grouponService.myGroupon(showType);
        return BaseRespVo.ok(wxListBean);
    }
}
