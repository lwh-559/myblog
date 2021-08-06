package com.hua.pojo.query;

import com.hua.pojo.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 博客查询实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/27 18:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}
