package com.status.service;

import com.status.domain.User;

public interface UserService {

    String login(String username, String pwd);

    /**
     * 验证根据手机号查询是否注册过
     * @param phone 手机号
     * @return 用户对象
     */
    User selectByPhone(String phone);

    /**
     * 注册用户
     * @param record 用户对象
     * @return 成功返回1否则返回0
     */
    int insertSelective(User record);
}
