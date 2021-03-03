package com.status.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @Package com.status.domain
* @author 张志宇
* @date 2021/2/28 22:43
* @version V1.0
*/
@Data
public class Video implements Serializable {
    private Integer id;

    /**
    * 视频标题
    */
    private String title;

    /**
    * 概述
    */
    private String summary;

    /**
    * 封面图
    */
    private String coverImg;

    /**
    * 价格,分
    */
    private Integer price;

    /**
     * 章
     */
    private List<Chapter> listChapter;

    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
    * 默认8.7，最高10分
    */
    private Double point;

    private static final long serialVersionUID = 1L;
}