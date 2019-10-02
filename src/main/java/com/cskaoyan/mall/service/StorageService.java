package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Storage;

import java.util.List;

/**
 * @author adore
 * @date 2019/10/2 11:49
 */
public interface StorageService {
    /**上传图片信息存入数据库
     * @param storage 文件信息
     * @return boolean
     */
    boolean insertStorage(Storage storage);

    List<Storage> getList(int page, int limit, String sort, String order);

    int getAmount();

    Storage update(Storage storage);

    boolean delete(Storage storage);
}
