package com.status.service.impl;

import com.status.constant.CacheKeyManager;
import com.status.handler.CustomException;
import com.status.mapper.VideoMapper;
import com.status.model.entity.Video;
import com.status.service.VideoService;
import com.status.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service.impl
 * @date 2021/2/4 8:44
 */
@Service
public class videoServiceImpl implements VideoService {

    @Autowired
    private BaseCache baseCache;

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> selectVideoList() {
        try {
            Object videoList = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST_KEY, () -> {
                List<Video> videos = videoMapper.selectVideoList();
                return videos;
            });
            if (videoList instanceof List){
                List<Video> videoLists = (List<Video>) videoList;
                return videoLists;
            }
        } catch (Exception e) {
            new CustomException("本地缓存异常");
        }
        return null;
    }
    @Override
    public Video selectByPrimaryKey(Integer id){
        String videoCacheKey = String.format(CacheKeyManager.INDEX_VIDEO_DKE_KEY,id);
        try {
            Object videoDel = baseCache.getTenMinuteCache().get(videoCacheKey, () -> {
                Video video = videoMapper.selectByPrimaryKey(id);
                return video;
            });
            if (videoDel instanceof Video){
                Video video = (Video) videoDel;
                return video;
            }
        } catch (ExecutionException e) {
            new CustomException("本地缓存异常");
        }
        return null;
    }
}
