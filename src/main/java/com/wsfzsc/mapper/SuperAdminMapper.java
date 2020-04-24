package com.wsfzsc.mapper;

import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.pojo.SuperAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuperAdminMapper {
    long countByExample(SuperAdminExample example);

    int deleteByExample(SuperAdminExample example);

    int deleteByPrimaryKey(Integer superadminId);

    int insert(SuperAdmin record);

    int insertSelective(SuperAdmin record);

    List<SuperAdmin> selectByExample(SuperAdminExample example);

    SuperAdmin selectByPrimaryKey(Integer superadminId);

    int updateByExampleSelective(@Param("record") SuperAdmin record, @Param("example") SuperAdminExample example);

    int updateByExample(@Param("record") SuperAdmin record, @Param("example") SuperAdminExample example);

    int updateByPrimaryKeySelective(SuperAdmin record);

    int updateByPrimaryKey(SuperAdmin record);

    SuperAdmin selectByUsername(@Param("userName") String userName);
}