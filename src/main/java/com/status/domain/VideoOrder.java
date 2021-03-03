package com.status.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @Package com.status.domain
* @author 张志宇
* @date 2021/2/27 12:36
* @version V1.0
*/
@Data
public class VideoOrder implements Serializable {
    private Integer id;

    /**
    * 订单唯一标识
    */
    private String outTradeNo;

    /**
    * 0表示未支付，1表示已支付
    */
    private Integer state;

    /**
    * 订单生成时间
    */
    private Date createTime;

    /**
    * 支付金额，单位分
    */
    private Integer totalFee;

    /**
    * 视频主键
    */
    private Integer videoId;

    /**
    * 视频标题
    */
    private String videoTitle;

    /**
    * 视频图片
    */
    private String videoImg;

    /**
    * 用户id
    */
    private Integer userId;
    /**
     * 用户信息
     */
    private User user;
    private static final long serialVersionUID = 1L;
}