package com.cskaoyan.mall.util;

/**
 * @Description 判断字符串是否为数字, 是返回该数字, 不是返回-1
 * @Author levi-j
 * @CreateDate 2019-10-03 09:13
 */
public class SearchUtils {
    public static int search(String str) {
        if (IntegerUtils.isInteger(str)) {
            return Integer.valueOf(str);
        } else {
            return -1;
        }
    }
}
