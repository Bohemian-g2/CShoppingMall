package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Address;
import com.wsfzsc.pojo.AddressExample;
import com.wsfzsc.pojo.UserInf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    /*根据用户ID查找该用户的收货地址*/
    List<Address> selectByUserId(@Param("userId") Integer userId);

    /**/
    int updateByAddressId(Address address);



}