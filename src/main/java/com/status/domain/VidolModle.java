package com.status.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.domain
 * @date 2021/2/4 8:46
 */
public class VidolModle implements Serializable {
    private int id;
    /**
     * 标题
     */
    private String title;
    /**
     * 概要
     */
    private String summary;
    /**
     * 价格
     */
    private int price;
    /**
     * 图片
     */
    private String coverImg;
    /**
     * 创建时间 JsonProperty字段返回给前端起别名，JsonFormat日期格式
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date creadeTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    //@JsonInclude(JsonInclude.Include.NON_NULL) 返回值为null时不返回给前端
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreadeTime() {
        return creadeTime;
    }

    public void setCreadeTime(Date creadeTime) {
        this.creadeTime = creadeTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "VidolModle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", creadeTime=" + creadeTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
