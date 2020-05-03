package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.SuperAdminMapper;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.service.SuperAdminService;
import com.wsfzsc.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    private SuperAdminMapper superAdminMapper;

    //检查账号密码
    @Override
    public String checkSuperNameAndPwd(String adminUsername, String logpass) {
        SuperAdmin superAdmin=superAdminMapper.selectByUsername(adminUsername);
        if(superAdmin==null){
            return "nameError";//用户名不存在
        }
        String passw= Encryption.Encrypt(logpass);
        if(!superAdmin.getSuperadminPassword().equals(passw)){
            return "passwError";//密码错误
        };
        return "success";//正确
    }

    //登录账号
    @Override
    public SuperAdmin LoginSuperadmin(String adminUsername, String logpass) {
        SuperAdmin superAdmin=superAdminMapper.selectByUsername(adminUsername);
        String passw= Encryption.Encrypt(logpass);
        if(superAdmin!=null) {
            if (superAdmin.getSuperadminPassword().equals(passw)) {
                return superAdmin;
            }
        }
        return null;
    }
    @Override
    public String updateSuperAdminInfo(SuperAdmin superAdmin){
        //密码格式:由数字和字母组成，且为6-18位
        String regex = "^[a-zA-Z0-9]{6,18}$";
        if(superAdmin.getSuperadminName().length()>20){
            return "nameError";
        }
        if(superAdmin.getSuperadminPassword()!=null&&!superAdmin.getSuperadminPassword().equals("")){
            if(!superAdmin.getSuperadminPassword().matches(regex)){
                return "passwError";
            }
            /*加密密码*/
            superAdmin.setSuperadminPassword(Encryption.Encrypt(superAdmin.getSuperadminPassword()));
        }
        superAdminMapper.updateByPrimaryKeySelective(superAdmin);
        return "success";
    }
}
