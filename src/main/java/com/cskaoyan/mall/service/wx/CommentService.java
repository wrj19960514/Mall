package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.vo.commentManage.CommentBean;

import java.util.Map;

public interface CommentService {
    CommentBean queryCommentList(int valueId, int type, int showType, int page, int size);

    Map countComment(int valueId, int type);

    Comment postComment(Comment comment);
}
