package com.status.controller;

import com.status.common.AjaxResult;
import com.status.service.VideoBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页轮播图
 * @author 86159
 */
@Api(value="首页轮播图",tags = "首页轮播图")
@RestController
@RequestMapping("api/v1/pub/banner")
public class VideoBannerController {

    @Autowired
    private VideoBannerService videoBannerService;

    /**
     * 查询首页轮播列表
     * @return
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParam(value = "首页轮播图")
    @GetMapping("list")
    public AjaxResult selectOrderList(){
        return AjaxResult.success(videoBannerService.selectVideoBannerList());
    }

}
