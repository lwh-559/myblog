package com.hua.mapper;

import com.hua.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分类持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/26 10:14
 **/
@Mapper
@Repository
public interface TypeMapper {
   Type getTypeById(@Param("id") Long id);
   Type getTypeByName(@Param("name") String name);
   List<Type> getTypeAll();
   Integer addType(Type type);
   Integer updateType(Type type);
   Integer delTypeById(@Param("id") Long id);
}
