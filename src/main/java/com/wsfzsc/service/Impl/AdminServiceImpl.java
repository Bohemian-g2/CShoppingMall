package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.AdminMapper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.util.Encryption;
import com.wsfzsc.util.GUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private GUID guid;

    @Override
    public String checkAdminNameAndPwd(String adminUsername, String logpass) {
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
    public Admin checkAdmin(String adminUsername, String logpass) {
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
    public String saveAdmin(Admin admin) {
        //密码格式:由数字和字母组成，且为6-18位
        String regex = "^[a-zA-Z0-9]{6,18}$";
        String regexPhone="^1[3578]\\d{9}$";
        if(!admin.getAdminPassword().matches(regex)){
            return "passwError";
        }
        if(!admin.getAdminPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(admin.getAdminName().length()>20){
            return "nameError";
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        /*设置注册时间*/
        admin.setAdminRegisterDate(formatter.format(date));
        /*自动生成账号*/
        admin.setAdminUsername(guid.getAdminID());
        /*加密密码*/
        admin.setAdminPassword(Encryption.Encrypt(admin.getAdminPassword()));
        adminMapper.insertSelective(admin);
        return admin.getAdminUsername();
    }
    public String checkSaveAdmin(Admin admin) {
        //密码格式:由数字和字母组成，且为6-18位
        String regex = "^[a-zA-Z0-9]{6,18}$";
        String regexPhone="^1[3578]\\d{9}$";
        if(!admin.getAdminPassword().matches(regex)){
            return "passwError";
        }
        if(!admin.getAdminPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(admin.getAdminName().length()>20){
            return "nameError";
        }
        return "success";
    }

    @Override
    public Admin getAdminByUsername(String adminUsername) {
        return null;
    }
}
