package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 11:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String nickname;//评论昵称
    private String email;//邮箱
    private String content;//内容
    private String avatar;//头像(地址)
    private Date createTime;//创建时间

    private Long blogId;//博客id
    private Long parentCommentId;//父评论id
    private String parentNickname;//父评论昵称

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;//父评论
    private boolean adminComment;//管理员评论
}
