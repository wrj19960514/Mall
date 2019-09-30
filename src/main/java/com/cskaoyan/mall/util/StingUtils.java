package com.cskaoyan.mall.util;

/**
 * @author qyh
 * @date 2019/9/30 20:43
 */
public class StingUtils {
    public static boolean isEmpty(String string) {
        if(string == null || "".equals(string.trim())){
            return true;
        }
        return false;
    }
}
