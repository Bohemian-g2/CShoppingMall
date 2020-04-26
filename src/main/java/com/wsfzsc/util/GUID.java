package com.wsfzsc.util;

import com.wsfzsc.mapper.AdminMapper;
import com.wsfzsc.mapper.UserInfMapper;

import java.util.List;
import java.util.UUID;

public class GUID {
    private int bit;
    private AdminMapper adminMapper;
    private UserInfMapper userInfMapper;
    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public UserInfMapper getUserInfMapper() {
        return userInfMapper;
    }

    public void setUserInfMapper(UserInfMapper userInfMapper) {
        this.userInfMapper = userInfMapper;
    }
    public int getBit() {
        return bit;
    }
    public void setBit(int bit) {
        this.bit = bit;
    }

    private String getUID(){
        String initUid=UUID.randomUUID().toString();
        initUid=initUid.replace("-","");
        String reUid=initUid.substring(6,6+bit);
        return reUid;
    }
    public  String getUserID(){
        String reUid=this.getUID();
        List<String> unames=userInfMapper.selectUsernames();
        while(unames.contains(reUid)){
            reUid=this.getUID();
        }
        return reUid;
    }

    public  String getAdminID(){
        String reUid=this.getUID();
        List<String> unames=adminMapper.selectUsernames();
        while(unames.contains(reUid)){
            reUid=this.getUID();
        }
        return reUid;
    }

}
