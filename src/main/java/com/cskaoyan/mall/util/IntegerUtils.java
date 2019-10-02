package com.cskaoyan.mall.util;

import java.util.regex.Pattern;

public class IntegerUtils {
    /**判断 string 是否是 int 类型
     * @author levi-j
     * @date 2019/10/02 17:52
     * @param string
     * @return boolean
     */
    public static boolean isInteger(String string) {
        if(string == null || "".equals(string.trim())){
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(string).matches();
    }
}
