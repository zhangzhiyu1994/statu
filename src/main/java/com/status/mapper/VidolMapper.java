package com.status.mapper;

import com.status.domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.mapper
 * @date 2021/2/4 8:46
 */
@Mapper
public interface VidolMapper {

    /**
     * 根据视频id查找视频对象
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId);


    /**
     * 查询全部视频列表
     * @return
     */
    List<Video> selectListByXML();



    /**
     * 查询全部视频列表
     * @return
     */
    @Select("select * from video")
    List<Video> selectList();

    /**
     * 新增视频列表
     * @param video
     * @return
     */
    int insertVideo(Video video);

    /**
     * 批量新增视频列表
     * @param list
     * @return
     */
    int insertVideoList(List<Video> list);
}
