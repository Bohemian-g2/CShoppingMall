package com.wsfzsc.service;

import com.wsfzsc.mapper.CommentMapper;
import com.wsfzsc.pojo.Comment;
import com.wsfzsc.pojo.CommentHelper;
import com.wsfzsc.pojo.UserInf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface CommentService {
    /*得到符合条件的评论数据*/
    public Map<String,Object> getAllCommentBySec(int currentPage, int pageSize, CommentHelper comment);

    /*删除管理员信息*/
    public String deleteComment(List<Integer> ids);
}
