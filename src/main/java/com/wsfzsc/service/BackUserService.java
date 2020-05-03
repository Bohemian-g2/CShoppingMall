package com.wsfzsc.service;

import com.wsfzsc.pojo.UserInf;
import java.util.List;
import java.util.Map;

public interface BackUserService {
    /*得到符合条件的用户数据*/
    public Map<String,Object> getAllUserBySec(int currentPage, int pageSize, UserInf user);

    /*删除管理员信息*/
    public String deleteUser(List<Integer> ids);

    /*修改管理员信息*/
    public String updateUser(UserInf user);
}
