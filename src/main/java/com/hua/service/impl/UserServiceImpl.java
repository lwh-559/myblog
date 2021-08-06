package com.hua.service.impl;

import com.hua.mapper.UserMapper;
import com.hua.pojo.User;
import com.hua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层接口实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:52
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByNameAndPwd(String username, String password) {
        return userMapper.queryUserByNameAndPwd(username,password);
    }
}
