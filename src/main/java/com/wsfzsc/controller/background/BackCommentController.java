package com.wsfzsc.controller.background;

import com.wsfzsc.pojo.CommentHelper;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("comment")
public class BackCommentController {
    @Autowired
    private CommentService commentService;

    /*条件查询管理员页面*/
    @RequestMapping("querycommentListBySec")
    @ResponseBody
    public Map<String, Object> queryCommentListBySec(@RequestBody Map<String,String> map){
        CommentHelper comment=new CommentHelper();
        if(map.get("commentId")!=null&&!map.get("commentId").equals("")){
            comment.setCommentId(Integer.parseInt(map.get("commentId")));
        }
        if(map.get("ULN")!=null&&!map.get("ULN").equals("")){
            comment.setUserLoginName(map.get("ULN"));
        }
        if(map.get("commodityId")!=null&&!map.get("commodityId").equals("")){
            comment.setCommodityId(Integer.parseInt(map.get("commodityId")));
        }
        if(map.get("commodityName")!=null&&!map.get("commodityName").equals("")){
            comment.setCommodityName(map.get("commodityName"));
        }
        Map<String, Object> data =commentService.getAllCommentBySec(Integer.parseInt(map.get("currentPage")),6,comment);
        return data;
    }



    /*删除评论信息*/
    @RequestMapping("deleteCommentList")
    @ResponseBody
    public String deleteCommentList(@RequestBody Map<String,Object> map){
        List<Integer> ids=(List<Integer>)map.get("deleteIdList");
        System.out.println("==="+ids);
        String deleteResult=commentService.deleteComment(ids);
        return deleteResult;
    }

}
