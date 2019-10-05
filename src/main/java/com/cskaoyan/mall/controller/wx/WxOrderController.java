package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.WxOrderService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.OrderComment;
import com.cskaoyan.mall.vo.OrderSubmitVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
        map.put("count", data.size());
        map.put("data", data);
        map.put("totalPages", pageInfo.getSize());
        return BaseRespVo.ok(map);
    }

    @RequestMapping("/detail")
    public BaseRespVo getOrderDetail(int orderId) {
        return BaseRespVo.ok(wxOrderServiceImpl.getOrderDetail(orderId));
    }

    @RequestMapping("/cancel")
    public BaseRespVo cancelOrder(@RequestBody Map map) {
        Integer orderId = (Integer) map.get("orderId");
        wxOrderServiceImpl.cancelOrder(orderId);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/delete")
    public BaseRespVo deleteOrder(@RequestBody Map map) {
        Integer orderId = (Integer) map.get("orderId");
        wxOrderServiceImpl.deleteOrder(orderId);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/confirm")
    public BaseRespVo confirmOrder(@RequestBody Map map) {
        Integer orderId = (Integer) map.get("orderId");
        wxOrderServiceImpl.confirmOrder(orderId);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/refund")
    public BaseRespVo refundOrder(@RequestBody Map map) {
        Integer orderId = (Integer) map.get("orderId");
        wxOrderServiceImpl.refundOrder(orderId);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/submit")
    public BaseRespVo submitOrder(@RequestBody OrderSubmitVo orderSubmitVo) {
        boolean success = wxOrderServiceImpl.submitOrder(orderSubmitVo);
        if (success) {
            return BaseRespVo.ok(null);
        } else {
            BaseRespVo vo = new BaseRespVo();
            vo.setErrno(-1);
            vo.setErrmsg("数量不足");
            return vo;
        }
    }

    @RequestMapping("/prepay")
    public BaseRespVo prepayOrder(@RequestBody Map map) {
        Integer orderId = (Integer) map.get("orderId");
        wxOrderServiceImpl.prepayOrder(orderId);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/goods")
    public BaseRespVo getGoodsDetail(int orderId, int goodsId) {
        Map data = wxOrderServiceImpl.getGoodsDetail(orderId, goodsId);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("/comment")
    public BaseRespVo setGoodsComment(@RequestBody OrderComment orderComment) {
        boolean pass = wxOrderServiceImpl.setGoodsComment(orderComment);
        if(pass) {
            return BaseRespVo.ok(null);
        }else {
            BaseRespVo vo = new BaseRespVo();
            vo.setErrno(-1);
            vo.setErrmsg("图片数量应小于三张！！！");
            return vo;
        }
    }
}
