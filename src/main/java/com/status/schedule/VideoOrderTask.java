package com.status.schedule;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单,金额
 */

@Component
class VideoOrderTask {



    //每2秒执行一次
//    @Scheduled(fixedRate = 2000)
    public void sum(){

        //正常的是从数据库中查询

        System.out.println(LocalDateTime.now() + " 当前交易额="+ Math.random());

    }


}
