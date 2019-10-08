package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.mapper.FootprintMapper;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.address.FootListBean;
import com.cskaoyan.mall.vo.address.History;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Address> getAddressList() {
        AddressExample addressExample = new AddressExample();
        //如果没有默认地址则吧第一个地址设置为默认地址
        /*List<Address> addressesDefault = addressMapper.selectByExample(addressExample);
        for (int i = 0; i < addressesDefault.size(); i++) {
            while (addressesDefault.get(i).getIsDefault()) {
                Address firstAddress = addressesDefault.get(0);
                firstAddress.setIsDefault(true);
                addressMapper.updateByPrimaryKey(firstAddress);
            }
            break;

        }*/

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
        AddressExample addressExample = new AddressExample();
        //userId不能为空
        address.setUserId(1);
        address.setUserId(address.getUserId());
        //如果修改或者插入的地址是默认地址,需要对原来的默认地址进行修改
        if (address.getDefault()) {
            addressMapper.updateDefaultAddress(false, address.getDefault());
        }
        if (address.getId() != 0) {
            int i = addressMapper.updateByPrimaryKey(address);
        } else {
            int insert = addressMapper.insert(address);
            //获取相对应的code,并把原来的id改为code
            Region provinceCode = regionMapper.selectByPrimaryKey(address.getProvinceId());
            Region cityCode = regionMapper.selectByPrimaryKey(address.getCityId());
            Region areaCode = regionMapper.selectByPrimaryKey(address.getAreaId());
            address.setProvinceId(provinceCode.getCode());
            address.setCityId(cityCode.getCode());
            address.setAreaId(areaCode.getCode());
            int i = addressMapper.updateByPrimaryKey(address);
        }

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
    public FootListBean getFootPrint(int page, int size) {
        FootprintExample footprintExample = new FootprintExample();
        /*//获取username
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        //从username中拿到id
        int userId = userMapper.queryUserIdByUsername(principal);*/
        FootprintExample.Criteria criteria = footprintExample.createCriteria();
        //userid
        criteria.andUserIdEqualTo(1);
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
