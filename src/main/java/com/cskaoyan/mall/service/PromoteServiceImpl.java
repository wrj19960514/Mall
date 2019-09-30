package com.cskaoyan.mall.service;

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
    public ListBean getAdList(int pag, int limit, String sort, String order) {
        PageHelper.startPage(pag, limit);
        AdExample adExample = new AdExample();
        //根据sort的字段来升序或者降序排列
        adExample.setOrderByClause(sort + " " + order);
        List<Ad> ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> adPageInfo = new PageInfo<>(ads);
        long total = adPageInfo.getTotal();
        //返回的json数据
        ListBean listBean = new ListBean();
        listBean.setItems(ads);
        listBean.setTotal(total);
        return listBean;
    }
}
