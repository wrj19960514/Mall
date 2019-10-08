package com.cskaoyan.mall.controller.wx;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.config.AliyunConfig;
import com.cskaoyan.mall.config.MallOssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileController {

    @Autowired
    MallOssConfig ossConfig;

    @Autowired
    AliyunConfig aliyunConfig;

    @RequestMapping("/page")
    public String page(){

        return "page";
    }

    @RequestMapping("file/upload")
    @ResponseBody
    public String uploadFile(MultipartFile myfile) throws IOException {
        InputStream inputStream = myfile.getInputStream();
        String bucket = ossConfig.getBucket();
        String endPoint = ossConfig.getEndPoint();
//        String accessKeyId = ossConfig.getAccessKeyId();
//        String accessSecret = ossConfig.getAccessSecret();
//        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String key = uuid + myfile.getOriginalFilename();
//        ossClient.putObject(new PutObjectRequest(bucket,key,inputStream));
        return "ok";
    }

}
