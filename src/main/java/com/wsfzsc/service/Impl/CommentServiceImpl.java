package com.wsfzsc.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.tracing.dtrace.ArgsAttributes;
import com.wsfzsc.mapper.CommentMapper;
import com.wsfzsc.mapper.CommodityMapper;
import com.wsfzsc.mapper.UserInfMapper;
import com.wsfzsc.pojo.*;
import com.wsfzsc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Map<String, Object> getAllCommentBySec(int currentPage, int pageSize, CommentHelper comment) {
        Map<String, Object> data = new HashMap<>();
        //设置分页属性进行分页查询
        Page<CommentHelper> page = PageHelper.startPage(currentPage, pageSize,true);
        List<CommentHelper> list =commentMapper.selectCommentHelper(comment);
        data.put("total", page.getTotal());
        data.put("nowPage", currentPage);
        /*进行查询*/
        data.put("comments", list);
        return data;
    }

    @Override
    public String deleteComment(List<Integer> ids) {
        //批量删除操作
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdIn(ids);
        int sum=commentMapper.deleteByExample(commentExample);
        if(sum>0){
            return "deletesuccess";
        }
        return "deleteerror";
    }
}
