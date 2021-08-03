package com.hua.service;

import com.hua.pojo.User;

/**
 * 用户业务层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:51
 **/
public interface UserService {
    User queryUserByNameAndPwd(String username,String password);
}
