package com.wsfzsc.service;

import com.wsfzsc.pojo.SuperAdmin;

public interface SuperAdminService {
    public String checkSuperNameAndPwd(String adminUsername, String logpass);
    public SuperAdmin checkSuperadmin(String adminUsername, String logpass);
}
