package com.wsfzsc.controller.background;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("backuser")
public class BackUserController {
    @Autowired
    BackUserService userService;

    /*条件查询管理员页面*/
    @RequestMapping("queryUserListBySec")
    @ResponseBody
    public Map<String, Object> queryAdminListBySec(@RequestBody Map<String,String> map){
        UserInf user=new UserInf();
        if(map.get("userId")!=null&&!map.get("userId").equals("")){
            user.setUserId(Integer.parseInt(map.get("userId")));
        }
        if(map.get("loginName")!=null&&!map.get("loginName").equals("")){
            user.setLoginName(map.get("loginName"));
        }
        if(map.get("userName")!=null&&!map.get("userName").equals("")){
            user.setUserName(map.get("userName"));
        }
        if(map.get("identityNumber")!=null&&!map.get("identityNumber").equals("")){
            user.setIdentityNumber(map.get("identityNumber"));
        }
        if(map.get("userEmail")!=null&&!map.get("userEmail").equals("")){
            user.setUserEmail(map.get("userEmail"));
        }
        if(map.get("identityType")!=null&&!map.get("identityType").equals("")){
            user.setIdentityType(Integer.parseInt(map.get("identityType")));
        }
        if(map.get("userPhone")!=null&&!map.get("userPhone").equals("")){
            user.setUserPhone(Integer.parseInt(map.get("userPhone")));
        }
        if(map.get("sex")!=null&&!map.get("sex").equals("")){
            user.setSex(Integer.parseInt(map.get("sex")));
        }
        Map<String, Object> data =userService.getAllUserBySec(Integer.parseInt(map.get("currentPage")),6,user);
        return data;
    }



    /*删除管理员信息*/
    @RequestMapping("deleteUserList")
    @ResponseBody
    public String deleteAdminList(@RequestBody Map<String,Object> map){
        List<Integer> ids=(List<Integer>)map.get("deleteIdList");
        System.out.println("===="+ids);
        String deleteResult=userService.deleteUser(ids);
        return deleteResult;
    }

    /*修改管理员信息*/
    @RequestMapping("updateUser")
    @ResponseBody
    public String updateAdminList(@RequestBody Map<String,Object> map){
        UserInf user=new UserInf();
        user.setUserId(Integer.parseInt((String)map.get("userId")));
        user.setUserName((String)map.get("userName"));
        user.setUserEmail((String)map.get("userEmail"));
        user.setSex(Integer.parseInt((String)map.get("sex")));
        user.setUserPhone(Integer.parseInt((String)map.get("userPhone")));
        String updateResult=userService.updateUser(user);
        return updateResult;
    }
}
