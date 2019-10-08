package com.cskaoyan.mall.service.wx;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.config.MallOssConfig;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.address.FootListBean;
import com.cskaoyan.mall.vo.address.History;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author qyh
 * @date 2019/10/5 16:27
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    RegionMapper regionMapper;

    @Autowired
    FootprintMapper footprintMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MallOssConfig mallOssConfig;

    @Autowired
    StorageMapper storageMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public List<Address> getAddressList() {
        AddressExample addressExample = new AddressExample();
        List<Address> addresses = addressMapper.getAddressList(1);
        for (Address address : addresses) {
            String province = address.getProvinceName();
            String city = address.getCityName();
            String area = address.getAreaName();
            String detailedAddress = province + city + area + " " + address.getAddress();
            address.setDetailedAddress(detailedAddress);
        }
        return addresses;
    }

    @Override
    public Address getAddressDetail(int id) {
        Address address = addressMapper.selectByPrimaryKey(id);
        Address pca = addressMapper.getProvinceAndCityAndArea(address.getUserId(), id);
        address.setProvinceName(pca.getProvinceName());
        address.setCityName(pca.getCityName());
        address.setAreaName(pca.getAreaName());
        return address;
    }

    @Override
    public void saveAddress(Address address) {

    }

    @Override
    public List<Region> getRegionList(int pid) {
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria = regionExample.createCriteria();
        if (pid == 0) {
            criteria.andPidEqualTo(pid);
            List<Region> regions = regionMapper.selectByExample(regionExample);
            return regions;
        } else if (pid < 31) {
            criteria.andPidEqualTo(pid);
            List<Region> regions = regionMapper.selectByExample(regionExample);
            return regions;
        } else {
            criteria.andPidEqualTo(pid);
            List<Region> regions = regionMapper.selectByExample(regionExample);
            return regions;
        }
    }

    @Override
    public void deleteAddress(Address address) {
        addressMapper.deleteByPrimaryKey(address.getId());
    }

    @Override
    public void addFeedback(Feedback feedback) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo("user");
        int userId = userMapper.queryUserIdByUsername("user");
        feedback.setUserId(userId);
        feedback.setUsername("user");
        feedback.setStatus(0);
        int insert = feedbackMapper.insert(feedback);
    }

    @Override
    public Storage storeUpload(MultipartFile myfile) throws IOException {
        //oos
        InputStream inputStream = myfile.getInputStream();
        String bucket = mallOssConfig.getBucket();
        String accessKeyId = mallOssConfig.getAccessKeyId();
        String endPoint = mallOssConfig.getEndPoint();
        String accessSecret = mallOssConfig.getAccessSecret();
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String key = uuid + ".jpg";
        ossClient.putObject(new PutObjectRequest(bucket, key, inputStream));
        //把图片插入数据库
        int size = (int) myfile.getSize();
        String type = myfile.getContentType();
        String name = myfile.getOriginalFilename();
        Storage storage = new Storage();
        String url = "https://" + endPoint + "/" + key;
        storage.setKey(key);
        storage.setName(name);
        storage.setSize(size);
        storage.setUrl(url);
        storage.setType(type);
        storage.setDeleted(false);
        storage.setAddTime(new Date());
        storage.setUpdateTime(new Date());
        StorageExample storageExample = new StorageExample();
        int insert = storageMapper.insert(storage);
        Integer id = storage.getId();
        storage = storageMapper.selectByPrimaryKey(id);
        return storage;
    }

    @Override
    public FootListBean getFootPrint(int page, int size) {
        FootprintExample footprintExample = new FootprintExample();
        //获取username
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        //从username中拿到id
        int userId = userMapper.queryUserIdByUsername(principal);
        FootprintExample.Criteria criteria = footprintExample.createCriteria();
        //userid
        criteria.andUserIdEqualTo(userId);
        //分页
        PageHelper.startPage(page, size);
        //获取总数
        List<Footprint> footprints = footprintMapper.selectByExample(footprintExample);
        PageInfo<Footprint> footprintPageInfo = new PageInfo<>(footprints);
        long total = footprintPageInfo.getTotal();
        //footPrintList
        List<History> histories = footprintMapper.queryHistory(1);
        //返回的数据
        FootListBean footListBean = new FootListBean();
        footListBean.setFootprintList(histories);
        footListBean.setTotalPages(total);
        return footListBean;
    }

    @Override
    public void deleteFootprint(Footprint footprint) {
        footprintMapper.deleteByPrimaryKey(footprint.getId());
    }
}
