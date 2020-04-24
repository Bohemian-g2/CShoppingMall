package com.wsfzsc.service;

import com.wsfzsc.pojo.SuperAdmin;

public interface SuperAdminService {
    public String CheckSuperNameAndPwd(String adminUsername, String logpass);
    public SuperAdmin CheckSuperadmin(String adminUsername, String logpass);
}
