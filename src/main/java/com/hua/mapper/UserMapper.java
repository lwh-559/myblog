package com.hua.mapper;

import com.hua.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:46
 **/
@Mapper
@Repository
public interface UserMapper {
    User queryUserByNameAndPwd(@Param("username") String username,@Param("password") String password);
}
