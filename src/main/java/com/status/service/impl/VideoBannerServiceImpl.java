package com.status.service.impl;

import com.status.domain.VideoBanner;
import com.status.mapper.VideoBannerMapper;
import com.status.service.VideoBannerService;
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

    @Autowired
    private VideoBannerMapper videoBannerMapper;
    @Override
    public List<VideoBanner> selectVideoBannerList() {
        return videoBannerMapper.selectVideoBannerList();
    }
}
