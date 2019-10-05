package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.WxOrderService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/order")
public class WxOrderController {

    @Autowired
    WxOrderService wxOrderServiceImpl;

    @RequestMapping("/list")
    public BaseRespVo getOrderList(int showType, int page, int size) {
        PageHelper.startPage(page, size);
        List data = wxOrderServiceImpl.getOrderList(showType);
        PageInfo pageInfo = new PageInfo(data);
        Map map = new HashMap(16);
        map.put("count",data.size());
        map.put("data",data);
        map.put("totalPages",pageInfo.getSize());
        return BaseRespVo.ok(map);
    }

    @RequestMapping("/detail")
    public BaseRespVo getOrderDetail(int orderId){
        return BaseRespVo.ok(wxOrderServiceImpl.getOrderDetail(orderId));
    }

    @RequestMapping("/cancel")
    public BaseRespVo cancelOrder(){
        wxOrderServiceImpl.cancelOrder();
        return BaseRespVo.ok(null);
    }
}
