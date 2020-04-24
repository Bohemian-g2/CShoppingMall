package com.wsfzsc.service;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;

public interface AdminService {
    public String CheckAdminNameAndPwd(String adminUsername, String logpass);
    public Admin CheckAdmin(String adminUsername, String logpass);
    public Admin getAdminByUsername(String adminUsername);
}
