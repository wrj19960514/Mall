package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.CommentExample;

import java.util.List;

import com.cskaoyan.mall.vo.commentManage.CommentVo;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    List<Comment> selectCommentByGoodsId(@Param("goodsId") int goodsId);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentVo> queryCommentList(@Param("valueId") int valueId, @Param("type") int type);

    List<Comment> selectComment(int valueId, int type);

    List<Comment> selectCommentHasPic(int valueId, int type);

    void insertComment(@Param("comment") Comment comment);

}

