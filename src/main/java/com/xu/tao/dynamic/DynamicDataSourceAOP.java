package com.xu.tao.dynamic;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by xutao on 2017/12/16.
 */
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAOP {


    @Pointcut("@annotation(com.xu.tao.dynamic.TargetDataSource)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSourceContextHolder.setDataSource(method.getAnnotation(TargetDataSource.class).type());
    }

    @After("pointCut()")
    public void after(){
        DataSourceContextHolder.setDataSource(Type.DEFAULT);
    }
}
