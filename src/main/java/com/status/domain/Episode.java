package com.status.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* @Package com.status.domain
* @author 张志宇
* @date 2021/2/27 9:39
* @version V1.0
*/
@Data
public class Episode implements Serializable {
    private Integer id;

    /**
    * 集标题
    */
    private String title;

    /**
    * 第几集,全局顺序
    */
    private Integer num;

    /**
    * 顺序，章里面的顺序
    */
    private Integer ordered;

    /**
    * 播放地址
    */
    private String playUrl;

    /**
    * 章节主键id
    */
    private Integer chapterId;

    /**
    * 0表示免费，1表示首付
    */
    private Byte free;

    /**
    * 封面图
    */
    private String coverImg;

    /**
    * 视频id
    */
    private Integer videoId;

    /**
    * 创建时间
    */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}