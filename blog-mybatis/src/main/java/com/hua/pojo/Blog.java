package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 11:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private Long id;//博客id
    private String title;//博客标题
    private String content;//博客内容
    private String flag;//原创、转载、翻译
    private String firstPicture;//博客首图地址
    private Integer views;//查看人数
    private Integer commentCount;//评论数
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    private boolean appreciation;//是否开启赞赏
    private boolean commentabled;//是否开启评论
    private boolean published;//是否发布
    private boolean recommend;//是否开启推荐
    private boolean shareStatement;//是否开启分享声明

    private Long typeId;//类型id
    private Long userId;//用户id
    private String description;//对博客的描述

    private Type type;//博客类型
    private List<Comment> comments = new ArrayList<>();//博客评论
    private User user;//博主
}
