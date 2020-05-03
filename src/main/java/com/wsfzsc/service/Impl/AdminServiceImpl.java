package com.wsfzsc.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsfzsc.mapper.AdminMapper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.AdminExample;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.util.Encryption;
import com.wsfzsc.util.GUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private GUID guid;

    //登录时候的检查
    @Override
    public String checkAdminNameAndPwd(String adminUsername, String logpass) {
        Admin admin=adminMapper.selectByUsername(adminUsername);
        System.out.println(admin);
        if(admin==null){
            return "nameError";//用户名不存在
        }
        String passw= Encryption.Encrypt(logpass);
        if(!admin.getAdminPassword().equals(passw)){
            return "passwError";//密码错误
        };
        return "success";//正确
    }

    //存入session时候的检查
    @Override
    public Admin LoginAdmin(String adminUsername, String logpass) {
        Admin admin=adminMapper.selectByUsername(adminUsername);
        String passw= Encryption.Encrypt(logpass);
        if(admin!=null){
            if(admin.getAdminPassword().equals(passw)){
                return admin;
            }
        }
        return null;
    }

    //注册管理员
    @Override
    public String saveAdmin(Admin admin) {
        //密码格式:由数字和字母组成，且为6-18位
        String regex = "^[a-zA-Z0-9]{6,18}$";
        String regexPhone="^1[3578]\\d{9}$";
        if(!admin.getAdminPassword().matches(regex)){
            return "passwError";
        }
        if(!admin.getAdminPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(admin.getAdminName().length()>20){
            return "nameError";
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        /*设置注册时间*/
        admin.setAdminRegisterDate(formatter.format(date));
        /*自动生成账号*/
        admin.setAdminUsername(guid.getAdminID());
        /*加密密码*/
        admin.setAdminPassword(Encryption.Encrypt(admin.getAdminPassword()));
        adminMapper.insertSelective(admin);
        return admin.getAdminUsername();
    }

    @Override
    public Map<String, Object> getAllAdminBySec(int currentPage, int pageSize, Admin admin) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if(admin.getAdminName()!=null&&!admin.getAdminName().equals("")){
            criteria.andAdminNameLike("%"+admin.getAdminName()+"%");
        }
        if(admin.getAdminPhone()!=null&&!admin.getAdminPhone().equals("")){
            criteria.andAdminPhoneLike("%"+admin.getAdminPhone()+"%");
        }
        if(admin.getAdminRegisterDate()!=null&&!admin.getAdminRegisterDate().equals("")){
            criteria.andAdminRegisterDateLike("%"+admin.getAdminRegisterDate()+"%");
        }
        if(admin.getAdminUsername()!=null&&!admin.getAdminUsername().equals("")){
            criteria.andAdminUsernameLike("%"+admin.getAdminUsername()+"%");
        }
        Map<String, Object> data = new HashMap<>();
        //设置分页属性进行分页查询
        Page<Admin> page =PageHelper.startPage(currentPage, pageSize,true);
        List<Admin> list =new ArrayList<Admin>();
        if(admin.getAdminId()!=null&&admin.getAdminId()!=0){
            list.add(adminMapper.selectByPrimaryKey(admin.getAdminId()));
        }else{
            list=adminMapper.selectByExample(adminExample);
        }
        data.put("total", page.getTotal());
        data.put("nowPage", currentPage);
        /*进行查询*/
        data.put("admins", list);
        return data;
    }

    @Override
    public String deleteAdmin(List<Integer> ids) {
        //批量删除操作
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminIdIn(ids);
        int sum=adminMapper.deleteByExample(adminExample);
        if(sum>0){
            return "deletesuccess";
        }
        return "deleteerror";
    }

    @Override
    public String updateAdmin(Admin admin) {
        String regexPhone="^1[3578]\\d{9}$";
        if(!admin.getAdminPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(admin.getAdminName().length()>20){
            return "nameError";
        }

        adminMapper.updateByPrimaryKeySelective(admin);
        return "updateSuccess";
    }

    @Override
    public String updateAdminInfo(Admin admin){
        //密码格式:由数字和字母组成，且为6-18位
        String regex = "^[a-zA-Z0-9]{6,18}$";
        String regexPhone="^1[3578]\\d{9}$";
        if(!admin.getAdminPhone().matches(regexPhone)){
            return "phoneError";
        }
        if(admin.getAdminName().length()>20){
            return "nameError";
        }
        if(admin.getAdminPassword()!=null&&!admin.getAdminPassword().equals("")){
            if(!admin.getAdminPassword().matches(regex)){
                return "passwError";
            }
            /*加密密码*/
            admin.setAdminPassword(Encryption.Encrypt(admin.getAdminPassword()));
        }
        adminMapper.updateByPrimaryKeySelective(admin);
        return "success";
    }
}
