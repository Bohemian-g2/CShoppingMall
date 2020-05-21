package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    /*测试登录页面*/
    @RequestMapping("ToLogin")
    public String Login(){
        return "frontground/UserLogin";
    }

    @RequestMapping("ToReg")
    public String LogToReg(){
        return "front/userC/UserRegister";
    }

    @RequestMapping("LogToFind")
    public String LogToFind(){
        return "front/userC/FindoutPwd";
    }

    @Autowired
    private UserService userService;

    /*业务逻辑功能*/
    /*用户注册*/
    @RequestMapping("AddUser")
    public String AddUser(UserInf user, HttpServletRequest request){
        System.out.println("添加用户");
        System.out.println(user.toString());
        String result=userService.saveUser(user);
        System.out.println(1111111+result);
        request.getSession().setAttribute("nuser",user);
        return "front/userC/MbSetting";
    }

    /*用户登录*/
    /*登录检查*/
    @RequestMapping("LoginCheck")
    @ResponseBody
    public String LoginCheck(@RequestBody Map<String,String> map){
        String result=userService.checkUserNameAndPwd(map.get("logname"),map.get("logpass"));
        if(result.equals("nameError")){
                return "nameError";
        }
        if(result.equals("passwError")){
            return "passwError";
        }
        return "success";
    }

    /*登录进入系统*/
    @RequestMapping("LoginShop")
    public String LoginSuccess(String logname, String logpass, HttpServletRequest request){
        UserInf user = userService.LoginUser(logname,logpass);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "/frontground/UserInfoPage";
        }else{
            return "/frontground/UserLogin";
        }

    }

    /*登出*/
    @RequestMapping("LoginOut")
    public String LoginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return"/frontground/UserLogin";
    }

    /*重置密码*/
    @RequestMapping("updateForgetPwd")
    public String updateForgetPwd(String newPwd,HttpServletRequest request){
        if(newPwd.isEmpty()||"".equals(newPwd)){
            return "front/userC/UpdateForgetPwd";
        }
        String temp = request.getSession().getAttribute("getPwdUserId").toString();
        Integer userid = Integer.valueOf(temp);
        String result = userService.updateFgtPwd(userid,newPwd);
        System.out.println(result);
        request.getSession().removeAttribute("getPwdUserId");
        return "/frontground/UserLogin";
    }

    /*用户个人信息修改*/
    @RequestMapping("updateUserInfo")
    public ModelAndView updateUserInfo(String newPhone,String newEmail,
            Integer identype,String indenNum,Integer usex,HttpServletRequest request){
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){
            if(newEmail!=null&&!newEmail.equals("")){
                user.setUserEmail(newEmail);
            }
            if(newPhone!=null&&!newPhone.equals("")){
                user.setUserPhone(newPhone);
            }
            user.setSex(usex);
            user.setIdentityType(identype);
            user.setIdentityNumber(indenNum);
            String result= userService.updateUserInfo(user);
            modelAndView.setViewName("/frontground/UserInfoPage");
            return modelAndView;
        }
        modelAndView.setViewName(null);
        return modelAndView;
    }

    /*上传头像*/
    @RequestMapping("uploadTitle")
    @ResponseBody
    public ModelAndView uploadTitle(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request)throws Exception{
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        System.out.println("上传1user+"+user);
        System.out.println("上传1file+"+file);
        userService.uploadUserPic(file,user,request);
        System.out.println("??????");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/frontground/UserInfoPage");
        return modelAndView;
    }

    /*修改密码*/
    @RequestMapping("updatePwd")
    public ModelAndView updatePwd(String newPwd,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if(newPwd.isEmpty()||"".equals(newPwd)){
            modelAndView.setViewName(null);
            return modelAndView;
        }
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        String result = userService.updateFgtPwd(user.getUserId(),newPwd);
        System.out.println(result);
        modelAndView.setViewName("/frontground/UserLogin");
        request.getSession().removeAttribute("user");
        return modelAndView;
    }


}
