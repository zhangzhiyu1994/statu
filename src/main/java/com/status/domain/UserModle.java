package com.status.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.domain
 * @date 2021/2/23 20:14
 */
@Data
public class UserModle {
    private  int id;
    private String username;
    /**
     * JsonIgnore默认数据不返回前端
     */
    @JsonIgnore
    private String password;
}
