package com.wsfzsc.controller.background;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private SuperAdminService superAdminService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("Login")
    public String Login(){
        return "/background/backLogin";
    }

    /*登录检查*/
    @RequestMapping("LoginCheck")
    @ResponseBody
    public String LoginCheck(@RequestBody Map<String,String> map){
        String result1=superAdminService.CheckSuperNameAndPwd(map.get("logname"),map.get("logpass"));
        String result2=adminService.CheckAdminNameAndPwd(map.get("logname"),map.get("logpass"));
        System.out.println("=========result1="+result1+"result2"+result2);
        if(result1.equals("nameError")){
            if(result2.equals("nameError")){
                return "nameError";
            }
            if(result2.equals("passwError")){
                return "passwError";
            }
            return "success";
        }
        if(result1.equals("passwError")){
            return "passwError";
        }
        return "success";
    }

    /*登录进入系统*/
    @RequestMapping("LoginInSys")
    public String LoginSuccess(String logname,String logpass,HttpServletRequest request){
        SuperAdmin superAdmin=superAdminService.CheckSuperadmin(logname,logpass);
        Admin admin=adminService.CheckAdmin(logname,logpass);
        if(superAdmin!=null){
            request.getSession().setAttribute("superAdmin",superAdmin);
            return "/background/back";
        }else if(admin!=null){
            request.getSession().setAttribute("admin",admin);
            return "/background/back";
        }else{
            return"/background/backLogin";
        }

    }

    /*登出*/
    @RequestMapping("LoginOut")
    public String LoginOut(HttpServletRequest request){
        System.out.println("退出登录");
        request.getSession().removeAttribute("superAdmin");
        return"/background/backLogin";
    }

    @RequestMapping("SuperAdmin")
    public String SuperAdmin(){return "/background/back"; }

    @RequestMapping("OrdinaryAdmin")
    public String OrdinaryAdmin(){return "/background/ordinaryback"; }

}
