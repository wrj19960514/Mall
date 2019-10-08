package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.vo.address.FootListBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author qyh
 * @date 2019/10/5 16:27
 */
public interface AddressService {
    //获取收货地址列表
    List<Address> getAddressList();
    //收货地址详情
    Address getAddressDetail(int id);
    //保存收货地址
    void saveAddress(Address address);
    //获取区域列表
    List<Region> getRegionList(int pid);
    //删除收货地址
    void deleteAddress(Address address);
    //物流查询
    //添加反馈
    void addFeedback(Feedback feedback);
    //图片上传
    Storage storeUpload(MultipartFile myfile) throws IOException;
    //足迹列表
    FootListBean getFootPrint(int page, int size);
    //删除足迹
    void deleteFootprint(Footprint footprint);
    //用户FromId, 用于发送模板消息

}
