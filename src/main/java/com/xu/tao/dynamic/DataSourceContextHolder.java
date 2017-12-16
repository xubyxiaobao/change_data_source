package com.xu.tao.dynamic;

/**
 * Created by xutao on 2017/12/16.
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<Type> currDataTpye = new ThreadLocal<>();

    public static Type getDataSource(){
        Type dataSourceType = currDataTpye.get();
       if (dataSourceType==null){
           //设置默认值
           dataSourceType = Type.DEFAULT;
           currDataTpye.set(dataSourceType);
       }
       return dataSourceType;
    }

    public static void setDataSource(Type dataSourceType){
        currDataTpye.set(dataSourceType);
    }
}
