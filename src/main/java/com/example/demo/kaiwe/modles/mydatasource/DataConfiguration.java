package com.example.demo.kaiwe.modles.mydatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:
 */
@Configuration
public class DataConfiguration {

    @Bean(name = "gz")
    @ConfigurationProperties(prefix="spring.gz.datasource")
    public DataSource gz() {
        return new DruidDataSource();
    }

    @Bean(name = "sz")
    @ConfigurationProperties(prefix="spring.sz.datasource")
    public DataSource sz() {
        DataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(gz());
        //配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("gz", gz());
        dsMap.put("sz", sz());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }



    @Primary
    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory localSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource());
        return bean.getObject();
    }

    @Primary
    @Bean(name = "localSqlSessionTemplate")
    public SqlSessionTemplate localSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(localSqlSessionFactory());
    }

    /**
     *  配置@Transactional注解事物
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
