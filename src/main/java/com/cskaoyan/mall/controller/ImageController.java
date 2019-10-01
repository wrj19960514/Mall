package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.util.FileUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/coldStone")
public class ImageController {

    /**
     * 图片上传
     * @param img
     * @return
     */
    @PostMapping(value = "/img/upload")
    public String uploadImg(@RequestParam("image") MultipartFile img){
        //图片上传调用工具类
        try{
            //保存图片
            String path =  FileUtil.saveImg(img);
            return path;
        }catch (Exception e){
            return "上传图片失败";
        }
    }
}
