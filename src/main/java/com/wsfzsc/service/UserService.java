package com.wsfzsc.service;


import com.wsfzsc.pojo.UserInf;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface UserService {
    /*检查账号密码*/
    public String checkUserNameAndPwd(String userLoginName, String userPassword);

    /*检查账号密码，并返回查询对象(以存入session) */
    public UserInf LoginUser(String userLoginName, String userPassword);

    /*用户注册*/
    public String saveUser(UserInf user);

    /*用户个人信息修改*/
    public String updateUserInfo(UserInf user);

    /*验证密保后修改密码(忘记密码）*/
    public String updateFgtPwd(Integer userId,String newPwd);

    /*上传头像*/
    public String uploadUserPic(CommonsMultipartFile file,UserInf user, HttpServletRequest request) throws IOException;

    /*根据用户名查找*/
    public UserInf getUserByLoginName(String logname);
}
