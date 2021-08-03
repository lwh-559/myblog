package com.hua.mapper;

import com.hua.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/30 17:21
 **/
@Mapper
@Repository
public interface CommentMapper {
    //新增评论
    int addComment(Comment comment);
    int delCommentById(@Param("id") Long id);
    List<Comment> getCommentByParentCommentId(@Param("blogId") Long blogId,@Param("parentCommentId") Long parentCommentId);
}
