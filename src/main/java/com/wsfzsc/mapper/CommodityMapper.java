package com.wsfzsc.mapper;

import com.wsfzsc.pojo.Commodity;
import com.wsfzsc.pojo.CommodityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {
    long countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(Integer commodityId);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);

    Commodity selectByPrimaryKey(Integer commodityId);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);

    /**
     * 带商品类别外键
     * @param example
     * @return
     */
    List<Commodity> selectByExampleWithKind(CommodityExample example);

    //模糊查询
    List<Commodity> selectByCommodityName(String commodity_name);

    Commodity selectByPrimaryKeyWithKind(Integer commodityId);
}