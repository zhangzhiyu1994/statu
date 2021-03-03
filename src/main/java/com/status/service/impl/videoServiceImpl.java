package com.status.service.impl;

import com.status.domain.Video;
import com.status.mapper.VideoMapper;
import com.status.service.VideoService;
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
public class videoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> selectVideoList() {
        return videoMapper.selectVideoList();
    }
    @Override
    public Video selectByPrimaryKey(Integer id){
        return videoMapper.selectByPrimaryKey(id);
    }
}
