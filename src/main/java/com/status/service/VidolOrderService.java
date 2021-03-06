package com.status.service;

import com.status.model.entity.User;
import com.status.model.entity.VideoOrder;

import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service
 * @date 2021/2/4 8:44
 */

public interface VidolOrderService {

    /**
     * 查询全部视频列表
     * @return
     */
    List<VideoOrder> selectOrderList(Integer userId);

    /**
     * 查询用户下的全部视频列表
     * @return
     */
    List<User> selectUserOrderList();

    /**
     * 视频下单
     * @return 成功返回1
     */
    Integer  saveUserOrderById(VideoOrder videoOrde);

}
