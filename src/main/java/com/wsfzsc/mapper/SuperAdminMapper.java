package com.wsfzsc.mapper;

import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.pojo.SuperAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuperAdminMapper {

    SuperAdmin selectByUsername(@Param("userName") String userName);
}