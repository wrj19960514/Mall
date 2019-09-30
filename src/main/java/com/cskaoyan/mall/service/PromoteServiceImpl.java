package com.cskaoyan.mall.service;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.AdExample;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoteServiceImpl implements PromoteService {

    @Autowired
    AdMapper adMapper;

    @Override
    public ListBean getAdList(int page, int limit, String sort, String order, String name, String content) {
        PageHelper.startPage(page, limit);
        AdExample adExample = new AdExample();
        //根据sort的字段来升序或者降序排列
        adExample.setOrderByClause(sort + " " + order);
        //当标题与内容都不是空是全部查询 example 是用来加条件 如果不加查询全部的haul不加条件就可以了
        //根据广告内容或者广告标题进行模糊查询
        if (!StringUtils.isEmpty(name)) {
            adExample.createCriteria().andContentLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            adExample.createCriteria().andContentLike("%" + content + "%");
        }
        List<Ad> ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> adPageInfo = new PageInfo<>(ads);
        long total = adPageInfo.getTotal();
        //返回的数据
        ListBean listBean = new ListBean();
        listBean.setItems(ads);
        listBean.setTotal(total);
        return listBean;
    }
}
