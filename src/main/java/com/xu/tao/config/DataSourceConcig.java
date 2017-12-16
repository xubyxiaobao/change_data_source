package com.xu.tao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.xu.tao.constant.Const;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by xutao on 2017/12/16.
 */
@Configuration
public class DataSourceConcig {

    @Bean(name = Const.DataSourceType.PRIMARY)
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource getPrimary(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = Const.DataSourceType.SLAVE)
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource getSlave(){
        return DruidDataSourceBuilder.create().build();
    }
}
