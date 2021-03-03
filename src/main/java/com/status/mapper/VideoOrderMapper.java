package com.status.mapper;

import com.status.domain.User;
import com.status.domain.VideoOrder;
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

    int updateByPrimaryKeySelective(VideoOrder record);

    int updateByPrimaryKey(VideoOrder record);
}