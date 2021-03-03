package com.status.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.domain
 * @date 2021/2/27 9:39
 */
@Data
public class Chapter implements Serializable {
    private Integer id;

    /**
     * 视频主键
     */
    private Integer videoId;

    /**
     * 章节名称
     */
    private String title;

    /**
     * 章节顺序
     */
    private Integer ordered;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 集
     */
    private List<Episode> listEpisode;

    private static final long serialVersionUID = 1L;
}