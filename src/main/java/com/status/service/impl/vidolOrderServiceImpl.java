package com.status.service.impl;

import com.status.domain.User;
import com.status.domain.VideoOrder;
import com.status.mapper.VideoOrderMapper;
import com.status.service.VidolOrderService;
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
public class vidolOrderServiceImpl implements VidolOrderService {


    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Override
    public List<VideoOrder> selectOrderList() {
        return videoOrderMapper.selectVideoOrderList();
    }
    @Override
    public List<User> selectUserOrderList() {
        return videoOrderMapper.selectUserVideoOrderList();
    }
}
