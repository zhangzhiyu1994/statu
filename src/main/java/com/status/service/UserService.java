package com.status.service;

import com.status.common.AjaxResult;
import com.status.model.entity.User;
import com.status.model.request.LoginRequest;

public interface UserService {

    AjaxResult login(LoginRequest user);

    /**
     * 验证根据手机号查询是否注册过
     * @param phone 手机号
     * @return 用户对象
     */
    User selectByPhone(User user);

    /**
     * 注册用户
     * @param record 用户对象
     * @return 成功返回1否则返回0
     */
    int insertSelective(User record);

    /**
     * 查询个人信息
     * @param id
     * @return 用户对象
     */
    User selectByPrimaryKey(Integer id);
}
