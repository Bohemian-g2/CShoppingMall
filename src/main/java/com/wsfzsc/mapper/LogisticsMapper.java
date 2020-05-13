package com.wsfzsc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//模拟物流类
public interface LogisticsMapper {
    @Select("select logistics_address from logistics where indent_id = #{indentId}")
    public String selectOne(@Param("indentId") Integer indentId);

    @Update("update logistics set logistics_address=#{address} where indent_id = #{indentId}")
    public Integer updateOne(@Param("indentId") Integer indentId,@Param("address") String address);
}
