package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.bean.StorageExample;
import com.cskaoyan.mall.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
