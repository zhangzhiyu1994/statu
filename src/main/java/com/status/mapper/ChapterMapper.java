package com.status.mapper;

import com.status.model.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/27 9:39
* @version V1.0
*/
@Mapper
public interface ChapterMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}