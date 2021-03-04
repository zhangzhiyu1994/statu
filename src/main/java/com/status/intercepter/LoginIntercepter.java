package com.status.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.status.common.AjaxResult;
import com.status.constant.Constants;
import com.status.service.TokenService;
import com.status.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 登陆拦截器
 * @author 张志宇
 */
public class LoginIntercepter implements HandlerInterceptor {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TokenService tokenService;

    /**
     * 进入controller之前的方法
     * @param request 请求
     * @param response 响应
     * @param handler 参数
     * @return 返回值 true进入controller 否则false
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token))
        {
            token = request.getParameter("token");
        }
        if(!StringUtils.isEmpty(token))
        {
            //判断token是否合法
            Map<String, Object> loginUser = tokenService.getLoginUser(request);
            if(loginUser.get(Constants.LOGIN_USER_KEY)!=null && loginUser.get(Constants.LOGIN_USER_KEY)!="")
            {
                return true;
            }
            else
            {
                AjaxResult ajaxResult =  AjaxResult.error("token失效");
                String jsonStr = objectMapper.writeValueAsString(ajaxResult);
                renderJson(response,jsonStr);
                return false;
            }

        }
        else
        {
            AjaxResult ajaxResult =  AjaxResult.error("未登录，无法访问");
            String jsonStr = objectMapper.writeValueAsString(ajaxResult);
            renderJson(response,jsonStr);
            return false;
        }
        //return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    /**
     * 将请求拦截释放出去
     * @param response 响应
     * @param json json数据
     */
    private void renderJson(HttpServletResponse response,String json)
    {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter writer = response.getWriter())
        {
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
