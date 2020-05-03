package com.wsfzsc.controller.background;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ordiadmin")
public class OrdiAdmimController {
    @Autowired
    private AdminService adminService;

    /*业务逻辑功能*/
    /*管理员添加*/
    @RequestMapping("AddAdmin")
    @ResponseBody
    public String AddAdmin(@RequestBody Admin admin){
        System.out.println("进入添加管理员");
        String result=adminService.saveAdmin(admin);
        System.out.println(result);
        return result;
    }


    /*条件查询管理员页面*/
    @RequestMapping("queryAdminListBySec")
    @ResponseBody
    public Map<String, Object> queryAdminListBySec(@RequestBody Map<String,String> map){
        Admin admin=new Admin();
        if(map.get("adminId")!=null&&!map.get("adminId").equals("")){
            admin.setAdminId(Integer.parseInt(map.get("adminId")));
        }
        if(map.get("adminName")!=null&&!map.get("adminName").equals("")){
            admin.setAdminName(map.get("adminName"));
        }
        if(map.get("adminUsername")!=null&&!map.get("adminUsername").equals("")){
            admin.setAdminUsername(map.get("adminUsername"));
        }
        if(map.get("adminPhone")!=null&&!map.get("adminPhone").equals("")){
            admin.setAdminPhone(map.get("adminPhone"));
        }
        if(map.get("adminRegisterDate")!=null&&!map.get("adminRegisterDate").equals("")){
            admin.setAdminRegisterDate(map.get("adminRegisterDate"));
        }
        Map<String, Object> data =adminService.getAllAdminBySec(Integer.parseInt(map.get("currentPage")),6,admin);
        return data;
    }



    /*删除管理员信息*/
    @RequestMapping("deleteAdminList")
    @ResponseBody
    public String deleteAdminList(@RequestBody Map<String,Object> map){
        List<Integer> ids=(List<Integer>)map.get("deleteIdList");
        String deleteResult=adminService.deleteAdmin(ids);
        return deleteResult;
    }

    /*修改管理员信息*/
    @RequestMapping("updateAdmin")
    @ResponseBody
    public String updateAdminList(@RequestBody Map<String,Object> map){
        Admin admin=new Admin();
        admin.setAdminId(Integer.parseInt((String)map.get("adminId")));
        admin.setAdminName((String)map.get("adminName"));
        admin.setAdminPhone((String)map.get("adminPhone"));
        String updateResult=adminService.updateAdmin(admin);
        return updateResult;
    }

}
