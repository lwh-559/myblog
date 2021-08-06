package com.hua.service.impl;

import com.hua.mapper.BlogMapper;
import com.hua.mapper.CommentMapper;
import com.hua.pojo.Comment;
import com.hua.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论业务层接口实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/30 17:43
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    @Override
    public int addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.addComment(comment);
    }

    @Override
    public int delCommentById(Long id) {
        return commentMapper.delCommentById(id);
    }

    @Override
    public List<Comment> getCommentByParentCommentId(Long blogId, Long parentCommentId) {
        return commentMapper.getCommentByParentCommentId(blogId,parentCommentId);
    }

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentMapper.getCommentByParentCommentId(blogId, Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentMapper.getCommentByParentCommentId(blogId,id);
//            查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
//                    查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    private void recursively(Long blogId, Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.getCommentByParentCommentId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }
}
