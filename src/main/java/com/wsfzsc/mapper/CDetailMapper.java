package com.wsfzsc.mapper;

import com.wsfzsc.pojo.CDetail;
import com.wsfzsc.pojo.CDetailExample;
import com.wsfzsc.pojo.CDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CDetailMapper {
    long countByExample(CDetailExample example);

    int deleteByExample(CDetailExample example);

    int deleteByPrimaryKey(CDetailKey key);

    int insert(CDetail record);

    int insertSelective(CDetail record);

    List<CDetail> selectByExample(CDetailExample example);

    CDetail selectByPrimaryKey(CDetailKey key);

    int updateByExampleSelective(@Param("record") CDetail record, @Param("example") CDetailExample example);

    int updateByExample(@Param("record") CDetail record, @Param("example") CDetailExample example);

    int updateByPrimaryKeySelective(CDetail record);

    int updateByPrimaryKey(CDetail record);

    /**
     * 带外键
     * @param example
     * @return
     */
    List<CDetail> selectByExampleWithCommodityCart(CDetailExample example);
}