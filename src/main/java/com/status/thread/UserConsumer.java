package com.status.thread;

import com.status.mapper.UserMapper;
import com.status.model.entity.User;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费者
 */
public class UserConsumer implements Runnable {
    /**
     *消费者对象
     */
    private User data;
    /**
     *更新数据所调用的方法
     */
    private UserMapper userMapper;
    /**
     *阻塞队列
     */
    private LinkedBlockingQueue<Runnable> consumers;

    public UserConsumer(UserMapper userMapper, LinkedBlockingQueue<Runnable> consumers) {
        this.userMapper = userMapper;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        try {
            //执行方法更新数据
            userMapper.updateByPrimaryKeySelective(data);
        } finally {
            try {
                //最终释放消费者
                consumers.put(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setData(User data) {
        this.data = data;
    }
}
