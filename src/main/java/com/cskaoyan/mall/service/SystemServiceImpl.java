package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.LiteMall;
import com.cskaoyan.mall.mapper.LiteMallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SystemServiceImpl implements SystemService{

    @Autowired
    LiteMallMapper liteMallMapper;

    @Override
    public Map<String,String> getMall() {
        Map<String,String> map = new HashMap<>();
        map.put("cskaoyan_mall_mall_phone",liteMallMapper.getSystemMessage(12));
        map.put("cskaoyan_mall_mall_address",liteMallMapper.getSystemMessage(14));
        map.put("cskaoyan_mall_mall_name",liteMallMapper.getSystemMessage(6));
        map.put("cskaoyan_mall_mall_qq",liteMallMapper.getSystemMessage(8));
        return map;
    }

    @Override
    public Map<String,String> getExpress() {
        Map<String,String> map = new HashMap<>();
        map.put("cskaoyan_mall_express_freight_min",liteMallMapper.getSystemMessage(5));
        map.put("cskaoyan_mall_express_freight_value",liteMallMapper.getSystemMessage(7));
        return map;
    }

    @Override
    public Map<String,String> getOrder() {
        Map<String,String> map = new HashMap<>();
        map.put("cskaoyan_mall_order_comment",liteMallMapper.getSystemMessage(10));
        map.put("cskaoyan_mall_order_unpaid",liteMallMapper.getSystemMessage(1));
        map.put("cskaoyan_mall_order_unconfirm",liteMallMapper.getSystemMessage(3));
        return map;
    }

    @Override
    public Map<String,String> getWx() {
        Map<String,String> map = new HashMap<>();
        map.put("cskaoyan_mall_wx_index_new",liteMallMapper.getSystemMessage(2));
        map.put("cskaoyan_mall_wx_catlog_goods",liteMallMapper.getSystemMessage(11));
        map.put("cskaoyan_mall_wx_catlog_list",liteMallMapper.getSystemMessage(13));
        map.put("cskaoyan_mall_wx_share",liteMallMapper.getSystemMessage(4));
        map.put("cskaoyan_mall_wx_index_brand",liteMallMapper.getSystemMessage(15));
        map.put("cskaoyan_mall_wx_index_hot",liteMallMapper.getSystemMessage(9));
        map.put("cskaoyan_mall_wx_index_topic",liteMallMapper.getSystemMessage(16));
        return map;
    }

    @Override
    public boolean updateMall(LiteMall liteMall) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateDate = simpleDateFormat.format(date);
        boolean flag1 = liteMallMapper.updateSystemMessage("cskaoyan_mall_mall_address",liteMall.getCskaoyan_mall_mall_address(),updateDate);
        boolean flag2 = liteMallMapper.updateSystemMessage("cskaoyan_mall_mall_name",liteMall.getCskaoyan_mall_mall_name(),updateDate);
        boolean flag3 = liteMallMapper.updateSystemMessage("cskaoyan_mall_mall_phone",liteMall.getCskaoyan_mall_mall_phone(),updateDate);
        boolean flag4 = liteMallMapper.updateSystemMessage("cskaoyan_mall_mall_qq",liteMall.getCskaoyan_mall_mall_qq(),updateDate);
        return flag1 & flag2 & flag3 & flag4;
    }

    @Override
    public boolean updateExpress(LiteMall liteMall) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateDate = simpleDateFormat.format(date);
        boolean flag1 = liteMallMapper.updateSystemMessage("cskaoyan_mall_express_freight_min",liteMall.getCskaoyan_mall_express_freight_min(),updateDate);
        boolean flag2 = liteMallMapper.updateSystemMessage("cskaoyan_mall_express_freight_value",liteMall.getCskaoyan_mall_express_freight_value(),updateDate);

        return flag1 & flag2;
    }

    @Override
    public boolean updateOrder(LiteMall liteMall) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateDate = simpleDateFormat.format(date);
        boolean flag1 = liteMallMapper.updateSystemMessage("cskaoyan_mall_order_comment",liteMall.getCskaoyan_mall_order_comment(),updateDate);
        boolean flag2 = liteMallMapper.updateSystemMessage("cskaoyan_mall_order_unconfirm",liteMall.getCskaoyan_mall_order_unconfirm(),updateDate);
        boolean flag3 = liteMallMapper.updateSystemMessage("cskaoyan_mall_order_unpaid",liteMall.getCskaoyan_mall_order_unpaid(),updateDate);
        return flag1 & flag2 & flag3;
    }

    @Override
    public boolean updateWx(LiteMall liteMall) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateDate = simpleDateFormat.format(date);
        boolean flag1 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_catlog_goods",liteMall.getCskaoyan_mall_wx_catlog_goods(),updateDate);
        boolean flag2 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_catlog_list",liteMall.getCskaoyan_mall_wx_catlog_list(),updateDate);
        boolean flag3 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_index_brand",liteMall.getCskaoyan_mall_wx_index_brand(),updateDate);
        boolean flag4 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_index_hot",liteMall.getCskaoyan_mall_wx_index_hot(),updateDate);
        boolean flag5 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_index_new",liteMall.getCskaoyan_mall_wx_index_new(),updateDate);
        boolean flag6 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_index_topic",liteMall.getCskaoyan_mall_wx_index_topic(),updateDate);
        boolean flag7 = liteMallMapper.updateSystemMessage("cskaoyan_mall_wx_share",liteMall.getCskaoyan_mall_wx_share(),updateDate);
        return flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7;
    }
}