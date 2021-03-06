package com.status.controller;

import com.status.common.AjaxResult;
import com.status.model.entity.VideoOrder;
import com.status.model.request.VideoRequest;
import com.status.service.TokenService;
import com.status.service.VidolOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 订单视图层
 * @author 86159
 */
@Api(value = "视频订单管理a",tags = "视频订单管理a")
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController extends BaseController{

    @Autowired
    private VidolOrderService vidolOrderService;

    @Autowired
    private TokenService tokenService;

    @ApiOperation("下单接口")
    @ApiImplicitParam(name = "videoRequest", value = "视频信息", dataType = "VideoRequest")
    @PostMapping("save")
    public AjaxResult saveVideo(@RequestBody VideoRequest videoRequest, HttpServletRequest request)
    {
        Integer userId = (Integer) tokenService.getLoginUser(request).get("id");
        VideoOrder order = new VideoOrder();
        if (userId != null)
        {
            order.setUserId(userId);
            order.setVideoId(videoRequest.getId());
        }
        return toAjax(vidolOrderService.saveUserOrderById(order));
    }


    /**
     * 查询订单列表
     * @return
     */
    @GetMapping("list")
    public AjaxResult selectOrderList(){
        return AjaxResult.success(vidolOrderService.selectOrderList());
    }

}
