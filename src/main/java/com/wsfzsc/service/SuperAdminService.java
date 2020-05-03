package com.wsfzsc.service;

import com.wsfzsc.pojo.SuperAdmin;

public interface SuperAdminService {
    public String checkSuperNameAndPwd(String adminUsername, String logpass);
    public SuperAdmin LoginSuperadmin(String adminUsername, String logpass);
    /*修改个人信息*/
    public String updateSuperAdminInfo(SuperAdmin superAdmin);
}
