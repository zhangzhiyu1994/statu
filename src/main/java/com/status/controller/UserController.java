package com.status.controller;

import com.status.common.AjaxResult;
import com.status.model.entity.User;
import com.status.model.request.LoginRequest;
import com.status.service.TokenService;
import com.status.service.UserService;
import com.status.utils.Md5Utils;
import com.status.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.controller
 * @date 2021/2/23 20:07
 * 用户
 */
@Api(value="用户管理",tags = "用户管理")
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController extends BaseController{

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    /**
     * 登陆接口
     * @return 返回token
     */
    @ApiOperation("用户登陆接口")
    @ApiImplicitParam(name = "user", value = "用户登陆", dataType = "LoginRequest")
    @PostMapping("login")
    public AjaxResult login (@RequestBody LoginRequest user)
    {
        return userService.login(user);
    }

    /**
     * 注册接口接口
     * @return 返回token
     */

    @ApiOperation("用户注册接口")
    @ApiImplicitParam(name = "user", value = "新增用户信息", dataType = "User")
    @PostMapping("register")
    public AjaxResult register (@RequestBody User user)
    {
        User checkUser = userService.selectByPhone(user);
        if (checkUser != null)
        {
            return AjaxResult.error("手机号为"+user.getPhone()+"已经注册");
        }
        //设置随机头像
        user.setHeadImg(StringUtils.headImg());
        //MD5加密密码
        user.setPwd(Md5Utils.hash(user.getPwd()));
        return toAjax(userService.insertSelective(user));
    }
    @ApiOperation("查询用户信息接口")
    @ApiImplicitParam(name = "",value = "查询用户信息",dataType = "User")
    @GetMapping("user")
    public AjaxResult selectUserById(HttpServletRequest request)
    {
        //获取用户信息
        Map<String, Object> loginUser = tokenService.getLoginUser(request);
        Integer id = (Integer)loginUser.get("id");
        if (id == null )
        {
            AjaxResult.error();
        }
        return AjaxResult.success(userService.selectByPrimaryKey(id));
    }
}
