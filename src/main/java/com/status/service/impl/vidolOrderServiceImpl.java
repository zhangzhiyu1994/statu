package com.status.service.impl;

import com.status.handler.CustomException;
import com.status.mapper.ChapterMapper;
import com.status.mapper.EpisodeMapper;
import com.status.mapper.PlayRecordMapper;
import com.status.mapper.VideoMapper;
import com.status.mapper.VideoOrderMapper;
import com.status.model.entity.Episode;
import com.status.model.entity.PlayRecord;
import com.status.model.entity.User;
import com.status.model.entity.Video;
import com.status.model.entity.VideoOrder;
import com.status.service.VidolOrderService;
import com.status.task.AsyncManager;
import com.status.task.factory.AsyncFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Override
    public List<VideoOrder> selectOrderList(Integer userId) {
        return videoOrderMapper.selectVideoOrderList(userId);
    }
    @Override
    public List<User> selectUserOrderList() {
        return videoOrderMapper.selectUserVideoOrderList();
    }

    @Override
    public Integer  saveUserOrderById(VideoOrder videoOrder)
    {
        VideoOrder order = videoOrderMapper.selectOrderByIdAndStatus(videoOrder);
        if (order != null  )
        {
            if (order.getState() == 1)
            {
                //订单已经购买并且支付，返回0
                return 0;
            }
            //TODO 更新方法
        }
        //查询视频
        Video video = videoMapper.selectById(videoOrder.getVideoId());
        //构建订单信息
        if (video != null){
            videoOrder.setCreateTime(new Date());
            videoOrder.setOutTradeNo(UUID.randomUUID().toString());
            videoOrder.setState(1);
            videoOrder.setTotalFee(video.getPrice());
            videoOrder.setVideoImg(video.getCoverImg());
            videoOrder.setVideoTitle(video.getTitle());
        }
        int insert = videoOrderMapper.insert(videoOrder);

        if (insert > 0){
            //生成播放记录
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoOrder.getVideoId());
            if(episode == null){
                throw  new CustomException("没有集信息");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(videoOrder.getUserId());
            playRecord.setVideoId(videoOrder.getVideoId());
            AsyncManager.me().execute(AsyncFactory.videoLog(playRecord));
        }
        return insert;
    }
}
