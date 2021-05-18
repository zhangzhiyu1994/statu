package com.status.service.impl;

import com.status.common.AjaxResult;
import com.status.mapper.UserMapper;
import com.status.model.entity.User;
import com.status.model.request.LoginRequest;
import com.status.redis.RedisCache;
import com.status.service.TokenService;
import com.status.service.UserService;
import com.status.task.AsyncManager;
import com.status.thread.UserConsumer;
import com.status.thread.UserProducer;
import com.status.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisCache redisCache;

    @Override
    public AjaxResult login(LoginRequest user) {
        user.setPwd(Md5Utils.hash(user.getPwd()));
        //查询用户名和密码是否正确
        User user1 = userMapper.loginInfo(user);

        if (user1 != null){
            //构建返回数据
            Map<String, Object> map = new HashMap<>();
            map.put("token",tokenService.createdToken(user1));
            map.put("username",user1.getName());
            return AjaxResult.success("登陆成功",map);
        }
      return AjaxResult.error("登陆失败");
    }


    /**
     * 验证根据手机号查询是否注册过
     * @param user 手机号
     * @return 用户对象
     */
    @Override
    public User selectByPhone(User user){
        return userMapper.selectByPhone(user);
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

    /**
     * 查询个人信息
     * @param id id
     * @return 用户对象
     */
    @Override
    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    /**
     * 修改个人信息
     * @param user
     * @return 用户对象
     */
    @Override
    public int updateByPrimaryKey(User user){
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0){
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));
            //建立最大数为100的阻塞队列
            LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(100);
            user.setPhone("15940100213");
            //调用用户生产者
            UserProducer producer = new UserProducer(user,runnables, AsyncManager.me().executeMake());
            //启动生产者线程
            new Thread(producer).start();
            try {
                //将数据可以消费者对象的形式放入阻塞队列中
                runnables.put(new UserConsumer(userMapper,runnables));
            }catch (Exception e){
                System.out.println("消费者异常");
            }
        }
        return i;
    }
}
