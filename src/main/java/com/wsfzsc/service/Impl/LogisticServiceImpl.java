package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.LogisticsMapper;
import com.wsfzsc.pojo.Logistics;
import com.wsfzsc.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logisticService")
public class LogisticServiceImpl implements LogisticService {


    @Autowired
    private LogisticsMapper logisticsDao;

    @Override
    public String selectOne(Integer indentId) {
        String address = logisticsDao.selectOne(indentId);
        return address;
    }

    @Override
    public Integer updateOne(Integer indentId, String address) {
        Integer i = logisticsDao.updateOne(indentId, address);
        return i;
    }
}
