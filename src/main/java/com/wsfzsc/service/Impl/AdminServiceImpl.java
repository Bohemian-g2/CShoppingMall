package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.AdminMapper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String CheckAdminNameAndPwd(String adminUsername, String logpass) {
        Admin admin=adminMapper.selectByUsername(adminUsername);
        System.out.println(admin);
        if(admin==null){
            return "nameError";//用户名不存在
        }
        String passw= Encryption.Encrypt(logpass);
        if(!admin.getAdminPassword().equals(passw)){
            return "passwError";//密码错误
        };
        return "success";//正确
    }

    @Override
    public Admin CheckAdmin(String adminUsername, String logpass) {
        Admin admin=adminMapper.selectByUsername(adminUsername);
        String passw= Encryption.Encrypt(logpass);
        if(admin!=null){
            if(admin.getAdminPassword().equals(passw)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin getAdminByUsername(String adminUsername) {
        return null;
    }
}
