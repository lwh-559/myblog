package com.hua.service;

import com.hua.pojo.Type;

import java.util.List;

/**
 * 分类业务层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/26 10:42
 **/
public interface TypeService {
    Type getTypeById(Long id);
    Type getTypeByName(String name);
    List<Type> getTypeAll();
    Integer addType(Type type);
    Integer updateType(Type type);
    Integer delTypeById(Long id);
}
