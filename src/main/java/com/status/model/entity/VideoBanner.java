package com.status.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @Package com.status.domain
* @author 张志宇
* @date 2021/2/28 13:26
* @version V1.0
*/
@Data
public class VideoBanner implements Serializable {
    private Integer id;

    /**
    * 跳转地址
    */
    private String url;

    /**
    * 图片地址
    */
    private String img;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
    * 数字越小排越前
    */
    private Integer weight;

    private static final long serialVersionUID = 1L;
}