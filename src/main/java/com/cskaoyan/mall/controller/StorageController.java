package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.util.FileUtil;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * 资源存储
 * @author adore
 * @date 2019/9/30 22:35
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/storage")
public class StorageController {

    @Autowired
    StorageService storageService;
    @PostMapping("/create")
    public BaseRespVo fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Storage storage = FileUtil.saveImg(file, request);
        // 存入数据库
        boolean insert = storageService.insertStorage(storage);
        if (insert) {
            return BaseRespVo.ok(storage);
        }
        return BaseRespVo.error(null);
    }


    @GetMapping("/list")
    public BaseRespVo getList(HttpServletRequest httpServletRequest){
        int page =  Integer.parseInt(httpServletRequest.getParameter("page"));
        int limit = Integer.parseInt(httpServletRequest.getParameter("limit"));
        String sort = httpServletRequest.getParameter("sort");
        String order = httpServletRequest.getParameter("order");
        String key =  httpServletRequest.getParameter("key");
        String name = httpServletRequest.getParameter("name");
        Map<String,Object> map = new HashMap<>();
        if(key == null && name == null){
            int total = storageService.getAmount();
            map.put("total",total);
            List<Storage> items = storageService.getList(page, limit, sort, order);
            map.put("items",items);
            return BaseRespVo.ok(map);
        }else {
            List<Storage> items =  storageService.getSearch(page,limit,sort,order,key,name);
            int total = items.size();
            map.put("total",total);
            map.put("items",items);
            return BaseRespVo.ok(map);
        }
    }


    @PostMapping("/update")
    public BaseRespVo update(@RequestBody Storage storage){
         Storage updateStorage = storageService.update(storage);
         return BaseRespVo.ok(updateStorage);
    }

    @PostMapping("/delete")
    public BaseRespVo delete(@RequestBody Storage storage){
         boolean delete = storageService.delete(storage);
         if (delete){
             return BaseRespVo.ok(null);
         }
         return BaseRespVo.error(null);
    }
}