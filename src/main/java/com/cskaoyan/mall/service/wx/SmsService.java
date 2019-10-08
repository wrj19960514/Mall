package com.cskaoyan.mall.service.wx;

public interface SmsService {
    boolean sendMessage(String mobile, String s);
}
