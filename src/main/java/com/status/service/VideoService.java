package com.status.service;

import com.status.domain.Video;

import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service
 * @date 2021/2/4 8:44
 */

public interface VideoService {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> selectVideoList();

    Video selectByPrimaryKey(Integer id);

}
