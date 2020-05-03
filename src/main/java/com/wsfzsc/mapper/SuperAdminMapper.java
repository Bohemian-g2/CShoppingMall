package com.wsfzsc.mapper;

import com.wsfzsc.pojo.SuperAdmin;
import org.apache.ibatis.annotations.Param;


public interface SuperAdminMapper {

    SuperAdmin selectByUsername(@Param("userName") String userName);
    int updateByPrimaryKeySelective(SuperAdmin record);
}