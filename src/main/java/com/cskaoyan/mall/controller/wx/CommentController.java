package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.service.wx.CommentService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.commentManage.CommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/wx/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("list")
    public BaseRespVo getCommentList(int valueId,int type,int showType,int page,int size){
        CommentBean commentBean = commentService.queryCommentList(valueId, type, showType, page, size);
        BaseRespVo ok = BaseRespVo.ok(commentBean);
        return ok;
    }
    @RequestMapping("count")
    public BaseRespVo countComment(int valueId,int type){
        Map map = commentService.countComment(valueId, type);
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }
    @RequestMapping("post")
    public BaseRespVo postComment(@RequestBody Comment comment){
        Comment comment1 = commentService.postComment(comment);
        BaseRespVo ok = BaseRespVo.ok(comment1);
        return ok;
    }
}
