package com.wsfzsc.service;

import com.wsfzsc.pojo.CDetail;

import java.util.List;

public interface CDetailService {
    List<CDetail> selectAll(Integer userId);

    String insertOne(Integer commodityId, Integer userId);

    Integer updateCDetailMoney(Integer cartId, Integer commodityId, Integer opera);

    CDetail selectOne(Integer cartId, Integer commodityId);

    Integer deleteBatch(Integer cartId, List<Integer> commodityIdList);
}
