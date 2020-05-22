package com.wsfzsc.service;

import com.wsfzsc.pojo.Address;

import java.util.List;

public interface AddressService {

    /*新增收货地址*/
    public String AddAddress(Address address);

    /*修改收货地址*/
    public String updateAddress(Address address);

    /*删除收货地址*/
    public String deleteAddress(Integer addressId);

    /*查看收货地址*/
    public List<Address> showAddress(Integer userId);
}
