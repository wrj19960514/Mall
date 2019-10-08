package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectById(@Param("userId") String userId,
                             @Param("name") String name,
                             @Param("sort") String sort);

    List<Address> getAddressList(@Param("userId") int userId);

    Address selectDefaultAddressByUserId(@Param("userId") int userId);

    Address getProvinceAndCityAndArea(@Param("userId") int userId,
                                      @Param("id") int id);

    int updateDefaultAddress(@Param("isDefault")Boolean isDefault,
                             @Param("Default") Boolean Default);
}
