package com.status.mapper;

import com.status.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Mapper;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/3/4 15:58
* @version V1.0
*/
@Mapper
public interface PlayRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayRecord record);

    int insertSelective(PlayRecord record);

    PlayRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayRecord record);

    int updateByPrimaryKey(PlayRecord record);


    PlayRecord selectPlayLog(PlayRecord playRecord);
}