package com.status.controller;

import com.status.common.AjaxResult;
import com.status.service.VidolOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单视图层
 * @author 86159
 */
@RestController
@RequestMapping("api/v1/pub/order")
public class VideoOrderController {

    @Autowired
    private VidolOrderService vidolOrderService;

    /**
     * 查询订单列表
     * @return
     */
    @GetMapping("list")
    public AjaxResult selectOrderList(){
        return AjaxResult.success(vidolOrderService.selectOrderList());
    }

}
