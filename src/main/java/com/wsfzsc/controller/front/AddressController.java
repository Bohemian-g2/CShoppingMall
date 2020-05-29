package com.wsfzsc.controller.front;

import com.wsfzsc.mapper.AddressMapper;
import com.wsfzsc.pojo.Address;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressMapper addressMapper;

    /*新增收货地址*/
    @RequestMapping("AddAddress")
    public ModelAndView AddAddress(String addressName, String addressPhone,
                                   String province, String city, String district,
                                   String postCode, String detailedAddress, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        Address address = new Address();
        address.setUserId(user.getUserId());
        address.setAddressName(addressName);
        address.setAddressPhone(Integer.parseInt(addressPhone));
        address.setAddressProvince(province);
        address.setAddressCity(city);
        address.setAddressDistrict(district);
        address.setAddressPostcode(Integer.parseInt(postCode));
        address.setDetailedAddress(detailedAddress);
        String result = addressService.AddAddress(address,user.getUserId());
        modelAndView.setViewName("/frontground/UserInfoPage");
        return modelAndView;
    }

    /*查看当前用户的收货地址*/
    @RequestMapping("showAddress")
    @ResponseBody
    public List<Address> showAddress(HttpServletRequest request){
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        List<Address> result = addressService.showAddress(user.getUserId());
        return result;
    }
    /*跳转页面，用户对当前地址进行操作*/
    @RequestMapping("JumpAndSaveAddress")
    public String JasD(@RequestParam("addressId")String addressId,HttpServletRequest request){
        Address ad = addressMapper.selectByPrimaryKey(Integer.valueOf(addressId));
        request.getSession().setAttribute("address",ad);
        return "frontground/AddressOpt";
    }

    /*删除收货地址*/
    @RequestMapping("DeleteAddress")
    public ModelAndView DeleteAddress(@RequestParam("addressId")String addressId,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String result = addressService.deleteAddress(Integer.parseInt(addressId));
        request.getSession().removeAttribute("address");
        modelAndView.setViewName("/frontground/UserInfoPage");
        return modelAndView;
    }

    /*收货地址更新*/
    @RequestMapping("UpdateAddress")
    public String UpdateAddress(String newName, String newPhone,
                                String newProvince, String newCity, String newDistrict,
                                String newPostcode, String newDetail, HttpServletRequest request){
        Address newAddress = (Address) request.getSession().getAttribute("address");
        newAddress.setAddressName(newName);
        newAddress.setAddressPhone(Integer.parseInt(newPhone));
        newAddress.setAddressProvince(newProvince);
        newAddress.setAddressCity(newCity);
        newAddress.setAddressDistrict(newDistrict);
        newAddress.setAddressPostcode(Integer.parseInt(newPostcode));
        newAddress.setDetailedAddress(newDetail);
        String result = addressService.updateAddress(newAddress);
        return "/frontground/UserInfoPage";

    }


}
