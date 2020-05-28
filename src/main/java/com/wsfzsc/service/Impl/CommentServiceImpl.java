package com.wsfzsc.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wsfzsc.mapper.CommentMapper;
import com.wsfzsc.pojo.Comment;
import com.wsfzsc.pojo.CommentExample;
import com.wsfzsc.pojo.CommentHelper;
import com.wsfzsc.service.CommentService;
import com.wsfzsc.util.CommentShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
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
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdIn(ids);
        int sum = commentMapper.deleteByExample(commentExample);
        if (sum > 0) {
            return "deletesuccess";
        }
        return "deleteerror";
    }

    @Override
    public List<CommentShow> getCmtByCID(Integer commodityId) {
        List<CommentShow>commentShowList=commentMapper.selectCommentByCID(commodityId);
        return commentShowList;
    }

    @Override
    public int saveComment(Comment comment){
        comment.setCommentTime(new Date());
        int number=commentMapper.insertSelective(comment);
        return number;
    }

    @Override
    public Integer insertComment(int id, String content) {
        Comment mycomment=new Comment();
        mycomment.setIndentId(id);
        mycomment.setContent(content);
        mycomment.setCommentTime( new Date(System.currentTimeMillis()));
        mycomment.setUserId(222);//从session中获得，先写死
        return commentMapper.insertSelective(mycomment);

    }

    @Override
    public List<Comment> getCommentByIndentid(Integer id) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andIndentIdEqualTo(id);
        return  commentMapper.selectByExample(commentExample);
    }
}
