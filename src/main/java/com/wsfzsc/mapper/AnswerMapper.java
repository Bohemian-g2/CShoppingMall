package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Answer;
import com.wsfzsc.pojo.AnswerExample;
import com.wsfzsc.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);


    /*通过用户id查找回答及设置的密保问题*/
    List<Answer> selectByUserIdWithQue(AnswerExample example);


    /*通过用户id查找回答*/
    Answer selectByUserIdAndQueId(@Param("userId") Integer userId,@Param("queId")Integer queId);



}