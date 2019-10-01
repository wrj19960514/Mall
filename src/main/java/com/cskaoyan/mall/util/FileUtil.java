package com.cskaoyan.mall.util;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.config.Constant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static String saveImg(MultipartFile file) {
        //获取文件上传的根目录 C:\Users\wanghao/upload/img
        String path = Constant.UPLOAD_PATH + Constant.IMG_FILE_NAME;

        //拿到文件的后缀名和UUID进行拼接形成新的文件名
        //4ca64e85b1544c96b4a6154bb521476f.jpg
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String saveName = uuid + "." + getFileSuffix(file.getOriginalFilename());

        // 保存
        try {
            // 保存文件图片
            File targetFile = new File(path);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(new File(path + "/" + saveName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String filePath = Constant.VIRTUAL_IMG_PATH;
        //返回相对路径  img/virtual/4ca64e85b1544c96b4a6154bb521476f.jpg
        return filePath + "/" + saveName;
    }

    private static String getFileSuffix(String path) {
        return getFileSuffix(path, "2");
    }

    private static String getFileSuffix(String path, String type) {
        if ((!StringUtils.isEmpty(path)) && path.indexOf(".") > 0) {
            // 名称
            String name = path.substring(0, path.lastIndexOf("."));
            // 后缀
            String suffix = path.substring(path.lastIndexOf(".") + 1);
            return StringUtils.equals("1", type) ? name : suffix;
        } else {
            return null;
        }
    }
}
