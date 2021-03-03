package com.status.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器通用配置类
 */
@Configuration
class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**");

//        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api/v1/pri/**");

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
