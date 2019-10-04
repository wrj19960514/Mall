package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.vo.ListBean;

import java.util.List;

/**
 * @author adore
 * @date 2019/10/2 11:49
 */
public interface StorageService {
    /**
     * 上传图片信息存入数据库
     *
     * @param storage 文件信息
     * @return boolean
     */
    boolean insertStorage(Storage storage);

    ListBean queryAllStorage(int page, int limit, String sort, String order);

    ListBean queryStorageByKeyAndName(int page, int limit, String sort, String order, String key, String name);

    void updateStorage(Storage storage);

    void deleteStorage(Storage storage);


}
