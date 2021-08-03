package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 友链实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

    private Long id;
    private String blogaddress;//网址
    private String blogname;//名称
    private Date createTime;//创建时间
    private String pictureaddress;//图片地址

}
