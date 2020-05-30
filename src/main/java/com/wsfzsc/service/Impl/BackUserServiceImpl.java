package com.wsfzsc.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wsfzsc.mapper.UserInfMapper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.pojo.UserInfExample;
import com.wsfzsc.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackUserServiceImpl implements BackUserService {
    @Autowired
    private UserInfMapper userInfMapper;

    @Override
    public Map<String, Object> getAllUserBySec(int currentPage, int pageSize, UserInf user) {
        UserInfExample userInfExample=new UserInfExample();
        UserInfExample.Criteria criteria = userInfExample.createCriteria();
        if(user.getUserName()!=null&&!user.getUserName().equals("")){
            criteria.andUserNameLike(user.getUserName());//姓名
        }
        if(user.getUserPhone()!=null&&user.getUserPhone().equals("")){
            criteria.andUserPhoneLike(user.getUserPhone());//电话(String)
        }
        if(user.getLoginName()!=null&&!user.getLoginName().equals("")){
            criteria.andLoginNameLike(user.getLoginName());//账号
        }
        if(user.getIdentityType()!=null&&user.getIdentityType()!=0){
            criteria.andIdentityTypeEqualTo(user.getIdentityType());//证件类型(int)
        }
        if(user.getIdentityNumber()!=null&&!user.getIdentityNumber().equals("")){
            criteria.andIdentityNumberLike(user.getIdentityNumber());//证件号
        }
        if(user.getUserEmail()!=null&&!user.getUserEmail().equals("")){
            criteria.andUserEmailLike(user.getUserEmail());//email
        }
        if(user.getSex()!=null&&user.getSex()!=0){
            criteria.andSexEqualTo(user.getSex());//证件类型(int)
        }
        Map<String, Object> data = new HashMap<>();
        //设置分页属性进行分页查询
        Page<Admin> page = PageHelper.startPage(currentPage, pageSize,true);
        List<UserInf> list =new ArrayList<UserInf>();
        if(user.getUserId()!=null&&user.getUserId()!=0){
            list.add(userInfMapper.selectByPrimaryKey(user.getUserId()));
        }else{
            list=userInfMapper.selectByExample(userInfExample);
        }
        data.put("total", page.getTotal());
        data.put("nowPage", currentPage);
        /*进行查询*/
        data.put("users", list);
        return data;
    }

    @Override
    public String deleteUser(List<Integer> ids) {
        //批量删除操作
        UserInfExample userExample=new UserInfExample();
        UserInfExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIn(ids);
        int sum=userInfMapper.deleteByExample(userExample);
        if(sum>0){
            return "deletesuccess";
        }
        return "deleteerror";
    }

    @Override
    public String updateUser(UserInf user) {
        String regexPhone="^1[3578]\\d{9}$";
        if(!user.getUserPhone().toString().matches(regexPhone)){
            return "phoneError";
        }
        if(user.getUserName().length()>20){
            return "nameError";
        }
        userInfMapper.updateByPrimaryKeySelective(user);
        return "updateSuccess";
    }
}
