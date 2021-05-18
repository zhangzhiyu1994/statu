package com.status.thread;

import com.status.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 生产者
 */
public class UserProducer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    /**
     *用户对账
     */
    private User user;
    /**
     *阻塞队列
     */
    private LinkedBlockingQueue<Runnable> consumers;
    /**
     *线程池
     */
    private ThreadPoolExecutor executor;

    /**
     * 构造函数
     * @param user 用户
     * @param consumers 队列
     * @param executor 线程池
     */
    public UserProducer(User user, LinkedBlockingQueue<Runnable> consumers, ThreadPoolExecutor executor) {
        this.user = user;
        this.consumers = consumers;
        this.executor = executor;
    }

    /**
     * 线程池方法
     */
    @Override
    public void run() {
        try {
            //获取队列数据，实际为空，并且将其设置成消费者对象
            UserConsumer consumer = (UserConsumer) consumers.take();
            consumer.setData(user);
            //消费者线程执行
            executor.execute(consumer);
        }catch (Exception e){
            LOGGER.error("生产者发生异常=======》",e);
        }
    }
}
