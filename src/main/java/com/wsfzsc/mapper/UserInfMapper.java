package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Indent;
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

    UserInf selectByUsername(@Param("userName") String userName);

    /*得到所有用户ID*/
    List<Integer> selectUserId();

    /*以用户id查询用户*/
    UserInf selectByUserId(@Param("userId") Integer userId);

    /*通过用户Id修改密码*/
    int updateByUserId(@Param("userId") Integer userId,@Param("newPwd")String newPwd);

    /*通过用户ID修改头像*/
    int updateTilByUserId(@Param("userId")Integer userId,@Param("UserTitle")String UserTitle);

}