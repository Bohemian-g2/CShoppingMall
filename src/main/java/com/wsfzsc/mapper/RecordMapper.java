package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Record;
import com.wsfzsc.pojo.RecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    /**
     * 带商品信息和用户信息查询，因为没有根据评论id查询的情况，所以不提供primarykey查询的方法
     */

    List<Record> selectByExampleWithUserCommodity(RecordExample example);
}