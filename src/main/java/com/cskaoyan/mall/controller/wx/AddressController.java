package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.wx.AddressService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.address.FootListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author qyh
 * @date 2019/10/5 16:26
 */
@RestController
@CrossOrigin
public class AddressController {

    @Autowired
    AddressService addressService;

    //获取收货地址列表
    @RequestMapping("/wx/address/list")
    public BaseRespVo getAddressList() {
        List<Address> addressList = addressService.getAddressList();
        BaseRespVo ok = BaseRespVo.ok(addressList);
        return ok;
    }
    //收货地址详情
    @RequestMapping("/wx/address/detail")
    public BaseRespVo getAddressDetail(int id) {
        Address addressDetail = addressService.getAddressDetail(id);
        BaseRespVo ok = BaseRespVo.ok(addressDetail);
        return ok;
    }
    //修改增加后保存地址
    @RequestMapping("/wx/address/save")
    public BaseRespVo saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setData(address.getId());
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }

    //获取区域列表
    @RequestMapping("/wx/region/list")
    public BaseRespVo getRegionList(int pid) {
        List<Region> regionList = addressService.getRegionList(pid);
        BaseRespVo ok = BaseRespVo.ok(regionList);
        return ok;
    }

    //删除收货地址
    @RequestMapping("/wx/address/delete")
    public BaseRespVo deleteAddress(@RequestBody Address address) {
        addressService.deleteAddress(address);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }

    //获取足迹列表
    @RequestMapping("/wx/footprint/list")
    public BaseRespVo getFootPrint(int page, int size) {
        FootListBean footPrint = addressService.getFootPrint(page, size);
        BaseRespVo ok = BaseRespVo.ok(footPrint);
        return ok;
    }

    //删除足迹
    @RequestMapping("/wx/footprint/delete")
    public BaseRespVo deleteFootprint(@RequestBody Footprint footprint) {
        addressService.deleteFootprint(footprint);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }

    //图片上传
    @RequestMapping("/wx/storage/upload")
    public BaseRespVo storeUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        Storage storage = addressService.storeUpload(file);
        BaseRespVo ok = BaseRespVo.ok(storage);
        return ok;
    }

    //意见反馈
    @RequestMapping("/wx/feedback/submit")
    public BaseRespVo addFeedback(@RequestBody Feedback feedback) {
        addressService.addFeedback(feedback);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrmsg("成功");
        respVo.setErrno(0);
        return respVo;
    }
}
