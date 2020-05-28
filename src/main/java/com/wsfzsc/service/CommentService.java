package com.wsfzsc.service;

import com.wsfzsc.mapper.CommentMapper;
import com.wsfzsc.pojo.Comment;
import com.wsfzsc.pojo.CommentHelper;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.util.CommentShow;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CommentService {
    /*后台得到符合条件的评论数据*/
    public Map<String,Object> getAllCommentBySec(int currentPage, int pageSize, CommentHelper comment);

    /*后台删除评论信息*/
    public String deleteComment(List<Integer> ids);

    public Integer insertComment(int id,String content);

    public List<Comment> getCommentByIndentid(Integer id);

    /*前台显示评论信息*/
    public List<CommentShow> getCmtByCID(Integer commodityId);

    /*前台插入评论信息*/
    public int saveComment(Comment comment);
}
