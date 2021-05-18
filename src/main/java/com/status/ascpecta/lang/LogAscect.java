package com.status.ascpecta.lang;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.ascpecta.lang
 * @date 2021/3/29 14:48
 */
@Aspect
@Component
public class LogAscect {

    private static final Logger logger = LoggerFactory.getLogger(LogAscect.class);

    /**
     * //配置切入点
     */
    @Pointcut("@annotation(com.status.ascpecta.lang.annotation.Log)")
    public void logPointCut(){

    }

    /**
     * 环绕通知
     * @param
     * @param
     */
    @Before("logPointCut()")
    public void doAfterRounding(JoinPoint joinPoint){
        try {
            Object[] args = joinPoint.getArgs();
            for (int i= 0 ; i < args.length; i++){
                System.out.println("执行sql"+args[i]);
            }



            logger.info("around执行方法之前");
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            System.out.println("执行方法"+method.getAnnotations());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
