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
        System.out.println(user);
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
        //密码格式：6-16位的数字+字母
        String regexpwd = "^[a-zA-Z0-9]{6,16}$";
        String regexPhone = "^1[3578]\\d{9}$";
        if(!user.getPassword().matches(regexpwd)){
            return "pwdError";
        }
        if(!user.getUserPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(user.getLoginName().length()>8){
            return "LoginNameError";
        }
        /*自动生成用户ID*/
        user.setUserId(guid.createUserID());
        /*加密密码*/
        user.setPassword(Encryption.Encrypt(user.getPassword()));
        userInfMapper.insertSelective(user);
        System.out.println(222222+user.toString());
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
        String prefix = fileName.substring(0,fileName.indexOf("."));
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = prefix+suffix;
        ServletContext sc = request.getSession().getServletContext();
        String path;
        String basePath = sc.getRealPath("/usertitle");
        File f = new File(basePath);
        if(!f.exists()){
            f.mkdirs();
        }
        File saveFile = new File(basePath+"/"+newFileName);
        System.out.println("_________");
        FileUtils.copyInputStreamToFile(file.getInputStream(),saveFile);
        String userTitle = newFileName;
        System.out.println("usertitle2+"+userTitle);
        System.out.println(basePath);
        userInfMapper.updateTilByUserId(user.getUserId(),userTitle);
        return "success";
    }


}
