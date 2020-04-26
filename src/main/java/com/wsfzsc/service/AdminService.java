package com.wsfzsc.service;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;

public interface AdminService {
    /*检查账号密码*/
    public String checkAdminNameAndPwd(String adminUsername, String logpass);

    /*检查账号密码，并返回查询对象*/
    public Admin checkAdmin(String adminUsername, String logpass);

    /*添加管理员数据*/
    public String saveAdmin(Admin admin);
    /*检查数据*/
    public String checkSaveAdmin(Admin admin);

    public Admin getAdminByUsername(String adminUsername);
}
