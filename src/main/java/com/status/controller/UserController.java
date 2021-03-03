package com.status.controller;

import com.status.common.AjaxResult;
import com.status.domain.User;
import com.status.service.UserService;
import com.status.utils.Md5Utils;
import com.status.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.controller
 * @date 2021/2/23 20:07
 * 用户
 */
@Api(value="用户管理",tags = "用户管理")
@RestController
@RequestMapping("api/vi/pri/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    
    /**
     * 登陆接口
     * @return 返回token
     */
    @ApiOperation("用户登陆接口")
    @ApiImplicitParam(name = "user", value = "用户登陆", dataType = "User")
    @PostMapping("login")
    public AjaxResult login (@RequestBody User user){

        return AjaxResult.success();
    }

    /**
     * 注册接口接口
     * @return 返回token
     */

    @ApiOperation("用户注册接口")
    @ApiImplicitParam(name = "user", value = "新增用户信息", dataType = "User")
    @PostMapping("register")
    public AjaxResult register (@RequestBody User user){
        User checkUser = userService.selectByPhone(user.getPhone());
        if (checkUser != null){
            return AjaxResult.error("手机号为"+user.getPhone()+"已经注册");
        }
        //设置随机头像
        user.setHeadImg(StringUtils.headImg());
        //MD5加密密码
        user.setPwd(Md5Utils.hash(user.getPwd()));
        return toAjax(userService.insertSelective(user));
    }

}
