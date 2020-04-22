package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Answer;
import com.wsfzsc.pojo.AnswerExample;
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

    /**
     * 查询回答问题表，用户，问题 相关信息 不提供根据回答表主键查询方法
     */
    List<Answer> selectByExampleWithUserQuestion(AnswerExample example);
}