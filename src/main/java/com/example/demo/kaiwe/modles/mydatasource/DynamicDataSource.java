package com.example.demo.kaiwe.modles.mydatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源为:{}",DataSourceContextHolder.getDB());
        String db = DataSourceContextHolder.getDB();
        return db;
    }
}
