package com.status.mapper;

import com.status.domain.Chapter;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/27 9:39
* @version V1.0
*/
public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}