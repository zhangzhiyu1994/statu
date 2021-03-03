package com.status.mapper;

import com.status.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/27 9:39
* @version V1.0
*/
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    /**
     * 注册用户
     * @param record 用户对象
     * @return 成功返回1否则返回0
     */
    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    /**
     * 验证根据手机号查询是否注册过
     * @param phone 手机号
     * @return 用户对象
     */
    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}