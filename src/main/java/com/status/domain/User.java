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
public class User implements Serializable {
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    private List<VideoOrder> list;

    private static final long serialVersionUID = 1L;
}