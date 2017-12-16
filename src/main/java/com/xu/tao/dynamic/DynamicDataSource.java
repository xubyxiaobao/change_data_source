package com.xu.tao.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xutao on 2017/12/16.
 */
@Primary
@Component
public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware{
    private ApplicationContext context;

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource().getName();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        //获取所有的数据源
        Map<String, DataSource> allDataSources = context.getBeansOfType(DataSource.class);
        //获取 数据源集合
        Map<Object,Object> targetDataSources = this.getTargetDataSources(allDataSources);
        //这里设置targetDataSources
        setTargetDataSources(targetDataSources);

        super.afterPropertiesSet();
    }

    //排除 DynamicDataSource 类型的数据源
    private Map<Object,Object> getTargetDataSources(Map<String, DataSource> allDataSources){
        Map<Object,Object> targetDataSources = new HashMap<>();
        for (Map.Entry<String, DataSource> entity : allDataSources.entrySet()) {
            DataSource dataSource = entity.getValue();
            if (!(dataSource instanceof DynamicDataSource)){
                targetDataSources.put(entity.getKey(),entity.getValue());
            }
        }
        return targetDataSources;
    }
}
