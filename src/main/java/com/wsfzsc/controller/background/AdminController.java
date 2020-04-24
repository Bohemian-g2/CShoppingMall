package com.wsfzsc.controller.background;

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
        System.out.println("======"+map.get("logname"));
        String result=superAdminService.CheckSuperNameAndPwd(map.get("logname"),map.get("logpass"));
        return result;
    }

    /*登录进入系统*/
    @RequestMapping("LoginInSys")
    public String LoginSuccess(String logname,String logpass,HttpServletRequest request){
        SuperAdmin superAdmin=superAdminService.CheckSuperadmin(logname,logpass);
        if(superAdmin==null){
            return"/background/backLogin";
        }else{
            request.getSession().setAttribute("superAdmin",superAdmin);
        }
        return "/background/back";
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
