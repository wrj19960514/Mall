package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
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
        if (file.isEmpty()) {
           return BaseRespVo.error(null);
        }
        // name
        String name = file.getOriginalFilename();
        // key
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String[] split = name.split("\\.");
        System.out.println(Arrays.toString(split));
        String key = name.replace(split[0],uuid);
        // size
        int size = (int)file.getSize();
        // type
        String type = file.getContentType();
        // url
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String packagePath = "wx/storage/fetch/";
        String url = basePath + packagePath + key;
        // storage对象
        Storage storage = new Storage();
        storage.setKey(key);
        storage.setName(name);
        storage.setSize(size);
        storage.setUrl(url);
        storage.setType(type);
        storage.setAddTime(new Date());
        storage.setUpdateTime(storage.getAddTime());
        // 存入本地
        URL resource = StorageController.class.getClassLoader().getResource("");
        File localFile = new File(resource.getPath() + "static/" + packagePath + key);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        file.transferTo(localFile);
        // 存入数据库
        boolean insert = storageService.insertStorage(storage);
        if (insert) {
            return BaseRespVo.ok(storage);
        }
        return BaseRespVo.error(null);
    }
}
