package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;//昵称
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private Integer type;//类型
    private String avatar;//头像
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
}
