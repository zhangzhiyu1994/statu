package com.status.mapper;

import com.status.domain.Episode;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/27 9:39
* @version V1.0
*/
public interface EpisodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Episode record);

    int insertSelective(Episode record);

    Episode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Episode record);

    int updateByPrimaryKey(Episode record);
}