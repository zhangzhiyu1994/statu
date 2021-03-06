package com.status.service.impl;

import com.status.constant.CacheKeyManager;
import com.status.handler.CustomException;
import com.status.model.entity.VideoBanner;
import com.status.mapper.VideoBannerMapper;
import com.status.service.VideoBannerService;
import com.status.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service.impl
 * @date 2021/2/4 8:44
 */
@Service
public class VideoBannerServiceImpl implements VideoBannerService {

    /**
     * 注入本地缓存类
     */
    @Autowired
    private BaseCache baseCache;

    @Autowired
    private VideoBannerMapper videoBannerMapper;
    @Override
    public List<VideoBanner> selectVideoBannerList() {
        try {
            //去本地缓存中取数据，如果没有则执行里面的查询数据库的方法，并且将返回的数据加到本地缓存里面
            Object o = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> videoBanners = videoBannerMapper.selectVideoBannerList();
                return videoBanners;
            });
            //去本地缓存中取数据，如果有则直接返回
            if (o instanceof List){
                List<VideoBanner> videoBanne = (List<VideoBanner>) o;
                return videoBanne;
            }
        } catch (Exception e) {
            new CustomException("本地缓存异常");
        }
        return null;
    }
}
