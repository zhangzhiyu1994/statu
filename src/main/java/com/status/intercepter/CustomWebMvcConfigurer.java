package com.status.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器通用配置类
 * @author 张志宇
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }
    /**
     * 拦截路径
     * @param registry 参数
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**")
                .excludePathPatterns("/api/v1/pri/user/login")
                .excludePathPatterns("/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);

    }



//    这个注释代码是视频未讲的，补充知识点哈
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**","/api/v1/pri/user/**")
//        .excludePathPatterns("/**/*.html","/**/*.js"); //配置不拦截某些路径;
//
//        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api/v1/pri/**")
//
//
//        WebMvcConfigurer.super.addInterceptors(registry);
//
//
//    }


    @Bean
    public LoginIntercepter getLoginInterceptor(){
        return new LoginIntercepter();
    }


}
