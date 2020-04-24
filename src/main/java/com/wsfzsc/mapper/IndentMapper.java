package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Indent;
import com.wsfzsc.pojo.IndentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndentMapper {
    long countByExample(IndentExample example);

    int deleteByExample(IndentExample example);

    int deleteByPrimaryKey(Integer indentId);

    int insert(Indent record);

    int insertSelective(Indent record);

    List<Indent> selectByExample(IndentExample example);

    Indent selectByPrimaryKey(Integer indentId);

    int updateByExampleSelective(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByExample(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByPrimaryKeySelective(Indent record);

    int updateByPrimaryKey(Indent record);
}