package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Collect;
import com.wsfzsc.pojo.CollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer collectId);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer collectId);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    /**
     * 根据用户id 查询评论表，用户，商品信息 不提供根据评论表主键查询方法
     */
    List<Collect> selectByExampleWithUserCommodity(CollectExample example);
}