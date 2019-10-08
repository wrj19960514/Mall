package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.mapper.CommentMapper;
import com.cskaoyan.mall.vo.commentManage.CommentBean;
import com.cskaoyan.mall.vo.commentManage.CommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentBean queryCommentList(int valueId, int type, int showType, int page, int size) {
        PageHelper.startPage(page,size);
        List<CommentVo> commentVos = commentMapper.queryCommentList(valueId, type);
        PageInfo<CommentVo> commentVoPageInfo = new PageInfo<>(commentVos);
        int total = (int)commentVoPageInfo.getTotal();
        CommentBean commentBean = new CommentBean();
        commentBean.setCurrentPage(page);
        commentBean.setCount(total);
        commentBean.setData(commentVos);
        return commentBean;
    }

    @Override
    public Map countComment(int valueId, int type) {
        List<Comment> comments = commentMapper.selectComment(valueId, type);
        int size = comments.size();
        List<Comment> comments1 = commentMapper.selectCommentHasPic(valueId, type);
        int size1 = comments1.size();
        Map<Object, Object> map = new HashMap<>();
        map.put("allCount",size);
        map.put("hasPicCount",size1);
        return map;
    }

    @Override
    public Comment postComment(Comment comment) {
        Date date = new Date();
        comment.setUpdateTime(date);
        comment.setAddTime(date);
        comment.setUserId(1);
        int i = commentMapper.insertComment(comment);
        return comment;
    }
}
