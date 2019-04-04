package com.geovis.config;

import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2019/1/21.
 */
public class DataSourceAopInDao {

    private static Logger log = LoggerFactory.getLogger(DataSourceAopInDao.class);

    @Before("execution(* com.geovis.mapper..*.find*(..)) "
            + " or execution(* com.geovis.mapper..*.get*(..)) "
            + " or execution(* com.geovis.mapper..*.query*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setRead();
    }

    @Before("execution(* com.geovis.mapper..*.insert*(..)) "
            + " or execution(* com.geovis.mapper..*.update*(..))"
            + " or execution(* com.geovis.mapper..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }

}
