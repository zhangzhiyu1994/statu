package com.status.service.impl;
import com.status.domain.User;
import com.status.mapper.UserMapper;
import com.status.service.TokenService;
import com.status.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(String username, String pwd) {
        //TODO 验证账户密码逻辑
      return tokenService.createdToken();
    }


    /**
     * 验证根据手机号查询是否注册过
     * @param phone 手机号
     * @return 用户对象
     */
    @Override
    public User selectByPhone(String phone){
        return userMapper.selectByPhone(phone);
    }

    /**
     * 注册用户
     * @param record 用户对象
     * @return 成功返回1否则返回0
     */
    @Override
    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }
}
