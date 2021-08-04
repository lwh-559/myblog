package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 留言板实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Long id;
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//留言内容
    private String avatar;//头像
    private Date createTime;//创建时间

    private Long parentMessageId;//父id
    private boolean adminMessage;//管理员留言

    //回复评论
    private List<Message> replyMessages = new ArrayList<>();//
    private Message parentMessage;//父评论
    private String parentNickname;//父昵称
}
