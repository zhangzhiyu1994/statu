package com.status.service;

import com.status.model.entity.PlayRecord;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service
 * @date 2021/3/4 16:14
 */
public interface PlayRecordServie {

    /**
     * 视频观看日志插入
     * @param playRecord 视频信息
     * @return
     */
    Integer insertPlayLog(PlayRecord playRecord);

    /**
     * 视频观看日志更新
     * @param playRecord 视频信息
     * @return
     */
    Integer updatePlayLog(PlayRecord playRecord);


    /**
     * 视频观看日志查询
     * @param playRecord 视频信息
     * @return
     */
    PlayRecord selectPlayLog(PlayRecord playRecord);
}
