package com.cskaoyan.mall.service.wx;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cskaoyan.mall.config.AliyunConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    AliyunConfig aliyunConfig;

    @Override
    public boolean sendMessage(String mobile, String code) {
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        String regionId = aliyunConfig.getSmsConfig().getRegionId();
        String templateCode = aliyunConfig.getSmsConfig().getTemplateCode();
        String signName = aliyunConfig.getSmsConfig().getSignName();

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(response.getData(), Map.class);
            String message = (String) map.get("Message");
            return "OK".equals(message);
        } catch (ServerException e) {
            return false;
            //e.printStackTrace();
        } catch (ClientException e) {
            return false;
            //e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
