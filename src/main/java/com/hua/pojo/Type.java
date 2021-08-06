package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客分类实体
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 11:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Long id;//类型id
    private String name;//类型名

    private List<Blog> blogs = new ArrayList<>();
}
