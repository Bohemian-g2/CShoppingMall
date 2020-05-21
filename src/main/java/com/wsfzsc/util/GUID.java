package com.wsfzsc.util;

import com.wsfzsc.mapper.AdminMapper;
import com.wsfzsc.mapper.UserInfMapper;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
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

    public  String getAdminID(){
        String reUid=this.getUID();
        List<String> unames=adminMapper.selectUsernames();
        while(unames.contains(reUid)){
            reUid=this.getUID();
        }
        return reUid;
    }
    /*
    * 自动生成用户ID
    * */
    public Integer createUserID(){
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        String time=dateFormat.format(now);
        Integer ran=0;
        Random random = new Random();
        int number1 = random.nextInt(10);
        String n1 = String.valueOf(number1);
        int number2 = random.nextInt(10);
        String n2 = String.valueOf(number2);
        int number3 = random.nextInt(10);
        String n3 = String.valueOf(number3);
        int number4 = random.nextInt(10);
        String n4 = String.valueOf(number4);
        int number5 = random.nextInt(10);
        String n5 = String.valueOf(number5);
        int number6 = random.nextInt(10);
        String n6 = String.valueOf(number6);
        String s = n1+n2+n3+n4+n5+n6;

        String temp2= time+s;
        Integer last = Integer.parseInt(temp2);

        return last;
    }



}
