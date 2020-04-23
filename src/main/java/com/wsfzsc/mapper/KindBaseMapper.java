package com.wsfzsc.mapper;

import com.wsfzsc.pojo.KindBase;
import com.wsfzsc.pojo.KindBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KindBaseMapper {
    long countByExample(KindBaseExample example);

    int deleteByExample(KindBaseExample example);

    int deleteByPrimaryKey(Integer kindId);

    int insert(KindBase record);

    int insertSelective(KindBase record);

    List<KindBase> selectByExample(KindBaseExample example);

    KindBase selectByPrimaryKey(Integer kindId);

    int updateByExampleSelective(@Param("record") KindBase record, @Param("example") KindBaseExample example);

    int updateByExample(@Param("record") KindBase record, @Param("example") KindBaseExample example);

    int updateByPrimaryKeySelective(KindBase record);

    int updateByPrimaryKey(KindBase record);
}