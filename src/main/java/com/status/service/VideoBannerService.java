package com.status.service;

import com.status.domain.VideoBanner;

import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service
 * @date 2021/2/4 8:44
 */

public interface VideoBannerService {

    /**
     * 查询轮播列表
     * @return
     */
    List<VideoBanner> selectVideoBannerList();

}
