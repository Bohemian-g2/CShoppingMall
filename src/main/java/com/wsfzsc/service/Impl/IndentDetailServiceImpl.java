package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.IndentDetailMapper;
import com.wsfzsc.pojo.IndentDetail;
import com.wsfzsc.pojo.IndentDetailExample;
import com.wsfzsc.service.IndentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indentDetailService")
public class IndentDetailServiceImpl implements IndentDetailService {

    @Autowired
    private IndentDetailMapper indentDetailDao;

    //显示对应订单所有商品信息
    @Override
    public List<IndentDetail> showById(Integer indentId) {
        IndentDetailExample indentDetailExample = new IndentDetailExample();
        IndentDetailExample.Criteria criteria = indentDetailExample.createCriteria();
        criteria.andIndentIdEqualTo(indentId);
        List<IndentDetail> indentDetails = indentDetailDao.selectByExampleWithIndentCommodity(indentDetailExample);
        return indentDetails;
    }
}
