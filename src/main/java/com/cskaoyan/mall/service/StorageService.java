package com.cskaoyan.mall.service;

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

<<<<<<< HEAD
    /*ListBean queryAllStorage(int page, int limit, String sort, String order);

    ListBean queryStorageByKeyAndName(int page, int limit, String sort, String order, String key, String name);

    void updateStorage(Storage storage);

    void deleteStorage(Storage storage);*/
=======
    /**
     * 获取图片信息
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    List<Storage> getList(int page, int limit, String sort, String order);

    /**
     * 查询图片总数
     * @return
     */
    int getAmount();

    /**
     * 更新图片信息
     * @param storage
     * @return
     */
    Storage update(Storage storage);

    /**
     * 删除图片
     * @param storage
     * @return
     */
    boolean delete(Storage storage);

    /**
     * 查找图片
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @param key
     * @param name
     * @return
     */
    List<Storage> getSearch(int page, int limit, String sort, String order, String key, String name);
>>>>>>> ecdb244ebff9467fa6502e663c618ab4dc568ec0
}
