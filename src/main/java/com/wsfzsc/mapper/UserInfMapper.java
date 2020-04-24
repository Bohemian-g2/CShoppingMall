package com.wsfzsc.mapper;

import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.pojo.UserInfExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfMapper {
    long countByExample(UserInfExample example);

    int deleteByExample(UserInfExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    List<UserInf> selectByExample(UserInfExample example);

    UserInf selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByExample(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
}