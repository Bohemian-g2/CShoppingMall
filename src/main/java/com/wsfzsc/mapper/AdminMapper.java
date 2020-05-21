package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.AdminExample;
import com.wsfzsc.pojo.SuperAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByUsername(@Param("userName") String userName);

    /*得到所有账号*/
    List<String> selectUsernames();
    /*得到管理员数据*/
    public List<Admin> selectByPageAndSelections(Admin admin);


}