package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.AddressMapper;
import com.wsfzsc.pojo.Address;
import com.wsfzsc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public String AddAddress(Address address,Integer userId) {
        List<Address> list = addressMapper.selectByUserId(userId);
        Integer maxNum = list.size();
        if (maxNum>5){
            System.out.println("地址已满。。。。");
            return "AddressFull";
        }else {
            System.out.println("正在添加地址"+address);
            addressMapper.insertSelective(address);
            System.out.println("添加完成"+address);
            return "success";
        }
    }

    @Override
    public String updateAddress(Address address) {
        System.out.println("用户地址正在更新:"+address);
        String result = String.valueOf(addressMapper.updateByAddressId(address));
        System.out.println("用户地址已更新"+address);
        return result;
    }

    @Override
    public String deleteAddress(Integer addressId) {
        System.out.println("准备删除地址编号:"+addressId);
        String result = String.valueOf(addressMapper.deleteByPrimaryKey(addressId));
        System.out.println("编号"+addressId+"地址已删除");
        return result;
    }

    @Override
    public List<Address> showAddress(Integer userId) {
        List<Address> list = addressMapper.selectByUserId(userId);
        return list;
    }
}
