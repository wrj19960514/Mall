package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.wx.GrouponService;
import com.cskaoyan.mall.vo.WxListBean;
import com.cskaoyan.mall.vo.promote.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adore
 * @date 2019/10/5 15:03
 */
@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    OrderHandleoptionMapper orderHandleoptionMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Override
    public WxListBean getGrouponList(int page, int size) {
        // 分页
        PageHelper.startPage(page, size);
        // 团购信息列表
        List<WxGrouponVo> wxGrouponVos = grouponRulesMapper.queryWxGrouponVoList();
        // 获取总数
        PageInfo<WxGrouponVo> wxGrouponVoPageInfo = new PageInfo<>(wxGrouponVos);
        long total = wxGrouponVoPageInfo.getTotal();
        WxListBean wxListBean = new WxListBean();
        wxListBean.setData(wxGrouponVos);
        wxListBean.setTotal(total);
        return wxListBean;
    }

    @Override
    public WxListBean myGroupon(int showType) {
        Subject subject = SecurityUtils.getSubject();
        // username
        String principal = (String) subject.getPrincipal();
        int userId = userMapper.queryUserIdByUsername(principal);
        MyGrouponVo myGrouponVo = new MyGrouponVo();
        List<MyGrouponVo> myGrouponVos = new ArrayList<>();
        List<Groupon> groupons = null;
        // 通过用户id查询该用户创建的团购
        if (showType == 0) {
            groupons = grouponMapper.queryCreatorGroupons(userId);
        }
        if (showType == 1) {
            groupons = grouponMapper.queryJoinerGroupons(userId);
        }
        for (Groupon groupon : groupons) {
            myGrouponVo.setGroupon(groupon);
            // rules
            System.out.println(groupon);
            Integer rulesId = groupon.getRulesId();
            System.out.println(rulesId);
            GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(groupon.getRulesId());
            myGrouponVo.setRules(grouponRules);
            // 订单数据
            Order order = orderMapper.selectByPrimaryKey(groupon.getOrderId());
            myGrouponVo.setActualPrice(order.getActualPrice());
            User user = userMapper.selectByPrimaryKey(groupon.getCreatorUserId());
            myGrouponVo.setCreator(user.getNickname());
            if (groupon.getUserId() == groupon.getCreatorUserId() && groupon.getGrouponId() == 0) {
                myGrouponVo.setCreator(true);
            }
            myGrouponVo.setId(groupon.getId());
            // 参与人数
            GrouponExample grouponExample = new GrouponExample();
            grouponExample.createCriteria().andGrouponIdEqualTo(groupon.getGrouponId());
            List<Groupon> groupons1 = grouponMapper.selectByExample(grouponExample);
            myGrouponVo.setJoinerCount(groupons1.size());
            myGrouponVo.setOrderId(order.getId());
            myGrouponVo.setOrderSn(order.getOrderSn());
            // 订单状态
            Short orderStatus = order.getOrderStatus();// 根据状态码查询状态
            if (orderStatus == 103) {
                myGrouponVo.setOrderStatusText("已取消(系统)");
            }
            // 商品列表
            OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
            orderGoodsExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);
            myGrouponVo.setGoodsList(orderGoods);
            // handleoption
            OrderHandleoptionExample orderHandleoptionExample = new OrderHandleoptionExample();
            orderHandleoptionExample.createCriteria().andOrderIdEqualTo(order.getId());
            List<OrderHandleoption> orderHandleoptions = orderHandleoptionMapper.selectByExample(orderHandleoptionExample);
            for (OrderHandleoption orderHandleoption : orderHandleoptions) {
                myGrouponVo.setHandleoption(orderHandleoption);
            }
            // 将一条团购信息放入list中
            myGrouponVos.add(myGrouponVo);
        }
        PageInfo<MyGrouponVo> myGrouponVoPageInfo = new PageInfo<>(myGrouponVos);
        long total = myGrouponVoPageInfo.getTotal();
        WxListBean wxListBean = new WxListBean();
        wxListBean.setData(myGrouponVos);
        wxListBean.setTotal(total);
        return wxListBean;
    }

    @Override
    public GrouponDetailVo detail(int grouponId) {
        GrouponDetailVo grouponDetailVo = new GrouponDetailVo();
        // groupon
        Groupon groupon = grouponMapper.selectByPrimaryKey(grouponId);
        grouponDetailVo.setGroupon(groupon);
        // creator
        User user = userMapper.selectByPrimaryKey(groupon.getUserId());
        Creator creator = new Creator();
        creator.setAvatar(user.getAvatar());
        creator.setNickname(user.getNickname());
        grouponDetailVo.setCreator(creator);
        // joiner
        List<Creator> joiners = grouponMapper.queryAllJoiner(grouponId);
        grouponDetailVo.setJoiners(joiners);
        // linkGrouponId 不知道是个啥
        grouponDetailVo.setLinkGrouponId(grouponId);
        // orderGoods
        List<OrderGood> orderGoodList = orderGoodsMapper.selectOrderGoodList(groupon.getOrderId());
        for (OrderGood orderGood : orderGoodList) {
            GoodsProductExample goodsProductExample = new GoodsProductExample();
            goodsProductExample.createCriteria().andGoodsIdEqualTo(orderGood.getGoodsId());
            List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(goodsProductExample);
            for (GoodsProduct goodsProduct : goodsProducts) {
                orderGood.setGoodsSpecificationValues(goodsProduct.getSpecifications());
            }
        }
        grouponDetailVo.setOrderGoods(orderGoodList);
        // orderInfo
        Order order = orderMapper.selectByPrimaryKey(groupon.getOrderId());
        OrderHandleoptionExample orderHandleoptionExample = new OrderHandleoptionExample();
        orderHandleoptionExample.createCriteria().andOrderIdEqualTo(order.getId());
        List<OrderHandleoption> orderHandleoptions = orderHandleoptionMapper.selectByExample(orderHandleoptionExample);
        for (OrderHandleoption orderHandleoption : orderHandleoptions) {
            order.setOrderHandleoption(orderHandleoption);
        }
        grouponDetailVo.setOrderInfo(order);
        // rules
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(groupon.getRulesId());
        grouponDetailVo.setRules(grouponRules);
        return grouponDetailVo;
    }
}
