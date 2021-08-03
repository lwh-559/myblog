package com.hua.service;

import com.hua.pojo.Comment;

import java.util.List;

/**
 * 评论业务层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/30 17:41
 **/
public interface CommentService {
    //新增评论
    int addComment(Comment comment);
    int delCommentById(Long id);
    List<Comment> getCommentByParentCommentId(Long blogId, Long parentCommentId);
    List<Comment> listCommentByBlogId(Long blogId);
}
