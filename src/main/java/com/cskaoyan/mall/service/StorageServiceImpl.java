package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.bean.StorageExample;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adore
 * @date 2019/10/2 11:50
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;
    @Override
    public boolean insertStorage(Storage storage) {
        System.out.println(storage);
        int insert = storageMapper.insert(storage);
        if (insert == 1) {
            return true;
        }
        return false;
    }

   /* @Override
    public ListBean queryAllStorage(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Storage> storages = storageMapper.queryAllStorage(sort, order);
        PageInfo<Storage> storagePageInfo = new PageInfo<>(storages);
        long total = storagePageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(storages);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean queryStorageByKeyAndName(int page, int limit, String sort, String order, String key, String name) {
        PageHelper.startPage(page,limit);
        name = "%"+ name + "%";
        List<Storage> storages = storageMapper.queryStorageByKeyAndName(sort, order,key,name);
        PageInfo<Storage> storagePageInfo = new PageInfo<>(storages);
        long total = storagePageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(storages);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public void updateStorage(Storage storage) {
        storageMapper.updateStorage(storage);
    }

    @Override
    public void deleteStorage(Storage storage) {
        Integer id = storage.getId();
        storageMapper.deleteStorage(id);
    }*/
}
