package com.status.mapper;

import com.status.model.entity.User;
import com.status.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/27 12:36
* @version V1.0
*/
@Mapper
public interface VideoOrderMapper {

    List<VideoOrder> selectVideoOrderList();

    List<User> selectUserVideoOrderList();
    int deleteByPrimaryKey(Integer id);

    int insert(VideoOrder record);

    int insertSelective(VideoOrder record);

    VideoOrder selectByPrimaryKey(Integer id);

    /**
     * 查询是否购买过
     * @param videoOrder
     * @return 视频对象
     */
    VideoOrder selectOrderByIdAndStatus(VideoOrder videoOrder);

    int updateByPrimaryKeySelective(VideoOrder record);

    int updateByPrimaryKey(VideoOrder record);
}