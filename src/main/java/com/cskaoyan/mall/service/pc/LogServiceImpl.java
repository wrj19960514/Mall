package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.bean.Log;
import com.cskaoyan.mall.mapper.LogMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public ListBean queryAllLogs(int page, int limit, String sort, String order) {
        //分页
        PageHelper.startPage(page, limit);
        //查询所有的日志logs并进行排序
        List<Log> logs = logMapper.queryAllLogs(sort, order);
        //求和
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        long total = logPageInfo.getTotal();
        //把total和logs数组封装到ListBean数组
        ListBean listBean = new ListBean();
        listBean.setTotal(total);
        listBean.setItems(logs);
        return listBean;
    }

    @Override
    public ListBean queryLogsByName(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        name = "%" + name + "%";
        List<Log> logs = logMapper.queryLogsByName(name, sort, order);
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        long total = logPageInfo.getTotal();
        //把total和logs数组封装到ListBean数组
        ListBean listBean = new ListBean();
        listBean.setTotal(total);
        listBean.setItems(logs);
        return listBean;
    }
}
