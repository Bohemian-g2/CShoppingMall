package com.wsfzsc.mapper;

import com.wsfzsc.pojo.IndentDetail;
import com.wsfzsc.pojo.IndentDetailExample;
import com.wsfzsc.pojo.IndentDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndentDetailMapper {
    long countByExample(IndentDetailExample example);

    int deleteByExample(IndentDetailExample example);

    int deleteByPrimaryKey(IndentDetailKey key);

    int insert(IndentDetail record);

    int insertSelective(IndentDetail record);

    List<IndentDetail> selectByExample(IndentDetailExample example);

    IndentDetail selectByPrimaryKey(IndentDetailKey key);

    int updateByExampleSelective(@Param("record") IndentDetail record, @Param("example") IndentDetailExample example);

    int updateByExample(@Param("record") IndentDetail record, @Param("example") IndentDetailExample example);

    int updateByPrimaryKeySelective(IndentDetail record);

    int updateByPrimaryKey(IndentDetail record);

    /**
     * 带外键
     */
    List<IndentDetail> selectByExampleWithIndentCommodity(IndentDetailExample example);

}