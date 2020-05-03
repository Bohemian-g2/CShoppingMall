package com.wsfzsc.service;

import com.github.pagehelper.PageInfo;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    /*检查账号密码*/
    public String checkAdminNameAndPwd(String adminUsername, String logpass);

    /*检查账号密码，并返回查询对象（以存入session）*/
    public Admin LoginAdmin(String adminUsername, String logpass);

    /*添加管理员数据*/
    public String saveAdmin(Admin admin);

    /*得到符合条件的管理员数据*/
    public Map<String,Object> getAllAdminBySec(int currentPage, int pageSize,Admin admin);

    /*删除管理员信息*/
    public String deleteAdmin(List<Integer> ids);

    /*修改管理员信息*/
    public String updateAdmin(Admin admin);

    /*修改个人信息*/
    public String updateAdminInfo(Admin admin);

}
