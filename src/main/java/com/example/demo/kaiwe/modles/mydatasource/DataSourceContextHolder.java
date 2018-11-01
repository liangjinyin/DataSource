package com.example.demo.kaiwe.modles.mydatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:
 */
@Slf4j
@Component
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final DsEnum DEFAULT_DS = DsEnum.GZ_DS;
    public static void setDB(DsEnum db) {
        log.info("切换到{}数据源",db.getMessage());
        contextHolder.set(db.getDs());
    }

    public static String getDB() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
