package com.example.demo.kaiwe.modles.mydatasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:
 */
@Aspect
@Order(-1)
@Component
@Slf4j
public class DataAspect {

    @Before("@annotation(com.example.demo.kaiwe.modles.mydatasource.DS)")
    public void beforeDSAnnotation(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        DsEnum dsEnum = null;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                //如果为自动，则根据cityId自动选择数据库
                if(DsEnum.AUTO_DS == annotation.value()) {
                    //预留功能 获取cid（城市id）的值
                    //Object[] args = point.getArgs();
                    String cid = "200";
                    dsEnum = DsEnum.createDSByCid(cid);
                }
                // 取出注解中的数据源名
                dsEnum = annotation.value();
                //切换数据源
                DataSourceContextHolder.setDB(dsEnum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
        }
    }

    @After("@annotation(com.example.demo.kaiwe.modles.mydatasource.DS)")
    public void afterDSAnnotation() {
        //还原数据源
        DataSourceContextHolder.clearDB();
    }
}
