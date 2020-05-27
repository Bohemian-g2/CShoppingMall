package com.wsfzsc.service.Impl;


import com.wsfzsc.mapper.UserInfMapper;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.UserService;
import com.wsfzsc.util.Encryption;
import com.wsfzsc.util.GUID;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfMapper userInfMapper;

    @Autowired
    private GUID guid;


    //登录验证
    @Override
    public String checkUserNameAndPwd(String userLoginName, String userPassword) {
        UserInf user = userInfMapper.selectByUsername(userLoginName);
        if(user==null){
            return "nameError";//用户名不存在
        }
        String password = Encryption.Encrypt(userPassword);
        if(!user.getPassword().equals(password)){
            return "pwdError";//密码错误
        }
        return "success";//正确
    }
    //检查存入session
    @Override
    public UserInf LoginUser(String userLoginName, String userPassword) {
        UserInf user = userInfMapper.selectByUsername(userLoginName);
        String pwd = Encryption.Encrypt(userPassword);
        if(user!=null){
            if(user.getPassword().equals(pwd)){
                return user;
            }
        }
        return null;
    }


    //新增用户
    @Override
    public String saveUser(UserInf user) {
        /*自动生成账号*/
        user.setUserId(guid.createUserID());
        user.setLoginName(guid.createUserID().toString());
        /*加密密码*/
        user.setPassword(Encryption.Encrypt(user.getPassword()));
        user.setUserTitle("UserTitle.jpg");
        userInfMapper.insertSelective(user);
        return user.getLoginName();
    }

    //修改用户信息
    @Override
    public String updateUserInfo(UserInf user) {
        String regexPhone="^1[3578]\\d{9}$";
        if(!user.getUserPhone().matches(regexPhone)){
            return "phoneError";
        }
        userInfMapper.updateByPrimaryKeySelective(user);
        return "success";
    }

    //忘记密码后重置密码
    @Override
    public String updateFgtPwd(Integer userId, String newPwd) {
        String regexpwd = "^[a-zA-Z0-9]{6,16}$";
        if(null==userId||newPwd.isEmpty()||"".equals(newPwd)){
            return "uidOrNewPwdError";
        }else if (!newPwd.matches(regexpwd)) {
                return "pwdError";
        }else{
            String result = Encryption.Encrypt(newPwd);
            userInfMapper.updateByUserId(userId,result);
            return "success";
        }
    }

    //上传头像
    @Override
    public String uploadUserPic(CommonsMultipartFile file, UserInf user, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = user.getLoginName()+suffix;
        ServletContext sc = request.getSession().getServletContext();
        String basePath = sc.getRealPath("/usertitle");
        File f = new File(basePath);
        if(!f.exists()){
            f.mkdirs();
        }
        File saveFile = new File(basePath+"/"+newFileName);
        FileUtils.copyInputStreamToFile(file.getInputStream(),saveFile);
        String userTitle = newFileName;
        userInfMapper.updateTilByUserId(user.getUserId(),userTitle);
        return "success";
    }
    @Override
    public UserInf getUserByLoginName(String logname) {
        UserInf userInf=userInfMapper.selectByUsername(logname);
        return userInf;
    }



}
