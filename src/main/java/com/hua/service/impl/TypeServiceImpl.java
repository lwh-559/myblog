package com.hua.service.impl;

import com.hua.mapper.TypeMapper;
import com.hua.pojo.Type;
import com.hua.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类业务层接口实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/26 10:43
 **/
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> getTypeAll() {
        return typeMapper.getTypeAll();
    }

    @Override
    public Integer addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Integer updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Integer delTypeById(Long id) {
        return typeMapper.delTypeById(id);
    }
}
