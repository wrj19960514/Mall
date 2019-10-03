package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.bean.StorageExample;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.github.pagehelper.PageHelper;
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


    @Override
    public List<Storage> getList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        StorageExample storageExample = new StorageExample();
        storageExample.createCriteria();
        storageExample.setDistinct(true);
        storageExample.setOrderByClause(sort +" " + order);
        List<Storage> items = storageMapper.selectByExample(storageExample);
        System.out.println(items);
        return items;
    }

    @Override
    public List<Storage> getSearch(int page, int limit, String sort, String order, String key, String name) {
        PageHelper.startPage(page, limit);
        StorageExample storageExample = new StorageExample();
        if(key != null && !key.equals("") && name != null && !name.equals("")) {
            storageExample.createCriteria().andKeyEqualTo(key).andDeletedNotEqualTo(true).andNameLike("%" + name + "%");
        }else if(key != null && !key.equals("")){
            storageExample.createCriteria().andDeletedNotEqualTo(true).andKeyEqualTo(key);
        }else if(name != null && !name.equals("") ){
            storageExample.createCriteria().andDeletedNotEqualTo(true).andNameLike("%" + name + "%");
        }
        storageExample.setDistinct(true);
        storageExample.setOrderByClause(sort +" "+ order);
        List<Storage> items = storageMapper.selectByExample(storageExample);
        return items;
    }

    @Override
    public int getAmount() {
        StorageExample storageExample = new StorageExample();
        int total = (int)storageMapper.countByExample(storageExample);
        return total;
    }


    @Override
    public Storage update(Storage storage) {
        StorageExample storageExample = new StorageExample();
        storageExample.createCriteria().andIdEqualTo(storage.getId());
        storageMapper.updateByExample(storage,storageExample);
        return storage;
    }

    @Override
    public boolean delete(Storage storage) {
        boolean flag = false;
        storage.setDeleted(true);
        StorageExample storageExample = new StorageExample();
        storageExample.createCriteria().andIdEqualTo(storage.getId());
        //逻辑删除
        int delete = storageMapper.updateByExample(storage,storageExample);
        if(delete == 1){
            flag = true;
        }
        return flag;
    }
}
