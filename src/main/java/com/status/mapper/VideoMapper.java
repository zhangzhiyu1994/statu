package com.status.mapper;

import com.status.model.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/28 22:43
* @version V1.0
*/
@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    /**
     * 查询视频列表
     * @return
     */
    List<Video> selectVideoList();

    /**
     * 查询单个视频
     * @param id 视频id
     * @return
     */
    Video selectById(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}