package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.mapper.CollectMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.collectManage.CollectVo;
import com.cskaoyan.mall.vo.collectManage.collectAndGood;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map queryCollectList(int type,int page,int size) {
       /* Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        int uid = userMapper.queryUserIdByUsername(principal);*/
        //分页
        PageHelper.startPage(page,size);
        //收藏跟商品一对一多表查询到的List
        List<collectAndGood> collectAndGoods = collectMapper.queryCollectList();
        for (collectAndGood collectAndGood : collectAndGoods) {
            int id = collectAndGood.getValueId();
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            collectAndGood.setBrief(goods.getBrief());
            collectAndGood.setName(goods.getName());
            collectAndGood.setPicUrl(goods.getPicUrl());
            collectAndGood.setRetailPrice(goods.getRetailPrice());
        }
        //求和
        PageInfo<collectAndGood> collectAndGoodPageInfo = new PageInfo<>(collectAndGoods);
        long total = collectAndGoodPageInfo.getTotal();
        //封装到ListBean中返回到controller层
        Map<Object, Object> map = new HashMap<>();
        map.put("totalPages",total);
        map.put("collectList",collectAndGoods);
        return map;
    }

    @Override
    public Map addOrDeleteCollect(CollectVo collectVo) {
        HashMap<Object, Object> map = new HashMap<>();
        int valueId = collectVo.getValueId();
        //查看数据库是否有该数据
        Collect collect = collectMapper.queryCollectByValueId(valueId);
       //有的话进行删除
        if(collect != null){
            collectMapper.delectCollectByValueId(valueId);
            map.put("type","delete");
            return map;
        }else{
            Collect collect1 = new Collect();
            Date date = new Date();
            collect1.setDeleted(0);
            collect1.setAddTime(date);
            collect1.setUpdateTime(date);
            collect1.setType(0);
            collect1.setUserId(1);
            collect1.setValueId(valueId);
            collectMapper.insertCollect(collect1);
            map.put("type","add");
            return map;
        }

    }
}
