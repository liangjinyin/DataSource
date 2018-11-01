package com.example.demo.kaiwe.modles.mydatasource;

import java.lang.annotation.*;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:  切换数据库注释
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.METHOD})
public @interface DS {
    DsEnum value() default DsEnum.GZ_DS;
}
