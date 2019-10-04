package com.cskaoyan.mall.controller.pc;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.pc.StorageService;
import com.cskaoyan.mall.util.FileUtil;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


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
}
