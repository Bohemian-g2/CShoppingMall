package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.IndentMapper;
import com.wsfzsc.pojo.Indent;
import com.wsfzsc.pojo.IndentExample;
import com.wsfzsc.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("indentService")
public class IndentServiceImpl implements IndentService {

    @Autowired
    private IndentMapper indentDao;
    @Override
    public List<Indent> showAll(Integer status) {
        IndentExample indentExample = new IndentExample();
        IndentExample.Criteria criteria = indentExample.createCriteria();
        criteria.andIndentStatusEqualTo(status);
        List<Indent> indents = indentDao.selectByExampleWithUserAddress(indentExample);
        return indents;
    }

    //修改状态
    @Override
    public Integer updateStatus(List<Integer> list, Integer upd_status) {
        Indent indent = new Indent();
        indent.setIndentStatus(upd_status);
        IndentExample indentExample = new IndentExample();
        IndentExample.Criteria criteria = indentExample.createCriteria();
        criteria.andIndentIdIn(list);
        Date date = new Date();
        //退货
        if(upd_status == 1){
            indent.setIndentDrawbackMoneyTime(date);
        }else if(upd_status == 3){
            indent.setIndentEndTime(date);
        }
        Integer i = indentDao.updateByExampleSelective(indent,indentExample);
        return i;
    }
}
