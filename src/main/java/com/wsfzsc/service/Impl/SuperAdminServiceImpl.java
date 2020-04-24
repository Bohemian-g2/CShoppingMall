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

    @Override
    public String CheckSuperNameAndPwd(String adminUsername, String logpass) {
        SuperAdmin superAdmin=superAdminMapper.selectByUsername(adminUsername);
        System.out.println(superAdmin);
        if(superAdmin==null){
            return "nameError";//用户名不存在
        }
        String passw= Encryption.Encrypt(logpass);
        if(!superAdmin.getSuperadminPassword().equals(passw)){
            return "passwError";//密码错误
        };
        return "success";//正确
    }

    @Override
    public SuperAdmin CheckSuperadmin(String adminUsername, String logpass) {
        SuperAdmin superAdmin=superAdminMapper.selectByUsername(adminUsername);
        String passw= Encryption.Encrypt(logpass);
        if(superAdmin!=null) {
            if (superAdmin.getSuperadminPassword().equals(passw)) {
                return superAdmin;
            }
        }
        return null;
    }
}
