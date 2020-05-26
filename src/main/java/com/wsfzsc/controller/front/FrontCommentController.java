package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.Comment;
import com.wsfzsc.service.CommentService;
import com.wsfzsc.util.CommentShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller("frontComment")
@RequestMapping("FrontComment")
public class FrontCommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("getCommentByCdtId")
    @ResponseBody
    public List<CommentShow> getCommentByCdtId(@RequestBody Map<String,String> map){
        List<CommentShow> commentShowList=commentService.getCmtByCID(Integer.parseInt(map.get("commodityId")));
        return commentShowList;
    }

    @RequestMapping("saveCommentByCdtId")
    @ResponseBody
    public String saveCommentByCdtId(@RequestBody Map<String,String> map) {
        Comment comment=new Comment(Integer.parseInt(map.get("userId")),
                Integer.parseInt(map.get("indentId")),map.get("content"));
        commentService.saveComment(comment);
        return "success";
    }

}
