package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.mapper.CollectMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.collectManage.CollectVo;
import com.cskaoyan.mall.vo.collectManage.collectAndGood;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public ListBean queryCollectList(int type,int page,int size) {
        //分页
        PageHelper.startPage(page,size);
        //收藏跟商品一对一多表查询到的List
        List<collectAndGood> collects = collectMapper.queryCollectList(type);
        //求和
        PageInfo<collectAndGood> collectAndGoodPageInfo = new PageInfo<>(collects);
        long total = collectAndGoodPageInfo.getTotal();
        //封装到ListBean中返回到controller层
        ListBean listBean = new ListBean();
        listBean.setTotal(total);
        listBean.setItems(collects);
        return listBean;
    }

    @Override
    public Map addOrDeleteCollect(CollectVo collectVo) {
        HashMap<Object, Object> map = new HashMap<>();
        int valueId = collectVo.getValueId();
        Collect collect = collectMapper.queryCollectByValueId(valueId);
        if(collect != null){
            collectMapper.delectCollectByValueId(valueId);
            map.put("type","delete");
            return map;
        }else{
            Collect collect1 = new Collect();
            Date date = new Date();
            collect1.setDeleted(0);
            collect.setAddTime(date);
            collect.setUpdateTime(date);
            collect.setType(0);
            collect.setUserId(11);
            collect.setValueId(valueId);
            collectMapper.insertCollect(collect1);
            map.put("type","add");
            return map;
        }

    }
}
