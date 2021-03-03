package com.status.mapper;

import com.status.domain.VideoBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @Package com.status.mapper
* @author 张志宇
* @date 2021/2/28 13:26
* @version V1.0
*/
@Mapper
public interface VideoBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoBanner record);

    int insertSelective(VideoBanner record);

    VideoBanner selectByPrimaryKey(Integer id);

    /**
     * 查询轮播列表
     * @return
     */
    List<VideoBanner> selectVideoBannerList();
    int updateByPrimaryKeySelective(VideoBanner record);

    int updateByPrimaryKey(VideoBanner record);
}