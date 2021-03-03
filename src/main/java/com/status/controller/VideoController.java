package com.status.controller;

import com.status.common.AjaxResult;
import com.status.service.VideoService;
import com.status.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单视图层
 * @author 86159
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 查询视频列表
     * @return
     */
    @GetMapping("list")
    public AjaxResult selectOrderList(){
        System.out.println(DateUtils.getMonthFristDate()+"--"+DateUtils.getMonthLastDate());
        return AjaxResult.success(videoService.selectVideoList());
    }

    /**
     * 查询订单列表
     * @return
     */
    @GetMapping("videodel")
    public AjaxResult selectVidelDel(@RequestParam(value = "id" ,required = true) Integer id){
        int a = 1/0;
        return AjaxResult.success(videoService.selectByPrimaryKey(id));
    }

}
