package com.status.ascpecta.lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张志宇 * @version V1.0
 * @Package com.status.ascpecta.lang.annotation
 * @date 2021/3/29 14:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Log {

    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public String businessType() default "";

    /**
     * 操作人类别
     */
    public String operatorType() default "";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
