package com.status.controller;

import com.status.ascpecta.lang.annotation.Log;
import com.status.common.AjaxResult;
import com.status.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频视图层
 * @author 86159
 */
@Api(value="公共视频管理",tags = "公共视频管理")
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 查询视频列表
     * @return
     */
    @ApiOperation("视频列表")
    @ApiImplicitParam(value = "视频列表")
    @GetMapping("list")
    @Log(title = "视频管理",businessType = "查询所有视频列表")
    public AjaxResult selectOrderList(){
        System.out.println("这是第一个");
        return AjaxResult.success(videoService.selectVideoList());
    }

    /**
     * 查询订单列表
     * @return
     */
    @ApiOperation("视频详情")
    @ApiImplicitParam(name = "id",value = "视频列表" ,dataType = "Integer")
    @GetMapping(value = { "/", "/{id}" })
    public AjaxResult selectVidelDel(@PathVariable(value = "id",required = true) Integer id){
        return AjaxResult.success(videoService.selectByPrimaryKey(id));
    }

}
