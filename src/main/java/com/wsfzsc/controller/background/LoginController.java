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
public class LoginController {
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
        String result1=superAdminService.checkSuperNameAndPwd(map.get("logname"),map.get("logpass"));
        String result2=adminService.checkAdminNameAndPwd(map.get("logname"),map.get("logpass"));
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
        SuperAdmin superAdmin=superAdminService.LoginSuperadmin(logname,logpass);
        Admin admin=adminService.LoginAdmin(logname,logpass);
        if(superAdmin!=null){
            request.getSession().setAttribute("superAdmin",superAdmin);
            return "/background/back";
        }else if(admin!=null){
            request.getSession().setAttribute("admin",admin);
            return "/background/ordinaryback";
        }else{
            return"/background/backLogin";
        }

    }

    /*登出*/
    @RequestMapping("LoginOut")
    public String LoginOut(HttpServletRequest request){
        request.getSession().removeAttribute("superAdmin");
        return"/background/backLogin";
    }

    /*个人信息修改*/
    @RequestMapping("updateSuperAndOrdi")
    @ResponseBody
    public String updateSuperAndOrdi(@RequestBody Map<String,Object> map,HttpServletRequest request){
        SuperAdmin superAdmin=(SuperAdmin)request.getSession().getAttribute("superAdmin");
        Admin admin=(Admin)request.getSession().getAttribute("admin");
        if(superAdmin!=null){
            superAdmin.setSuperadminPassword(null);//清除密码
            if(map.get("name")!=null&&!map.get("name").equals("")) {
                superAdmin.setSuperadminName((String) map.get("name"));
            }
            superAdmin.setSuperadminPassword((String) map.get("password"));
            String result=superAdminService.updateSuperAdminInfo(superAdmin);
            return result;
        }
        if(admin!=null){
            admin.setAdminPassword(null);//清除密码
            System.out.println("======="+(String)map.get("name"));
            if(map.get("name")!=null&&!map.get("name").equals("")){
                admin.setAdminName((String)map.get("name"));
            }
            admin.setAdminPassword((String)map.get("password"));
            if(map.get("phone")!=null&&!map.get("phone").equals("")){
                admin.setAdminPhone((String)map.get("phone"));
            }
            String result=adminService.updateAdminInfo(admin);
            return result;
        }
        return "error";
    }

}
