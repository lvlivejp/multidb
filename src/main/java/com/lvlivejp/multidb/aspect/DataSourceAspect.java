package com.lvlivejp.multidb.aspect;

import com.lvlivejp.multidb.annotation.RouteingDataSource;
import com.lvlivejp.multidb.datasource.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    @Before("@annotation(routeingDataSource)")
    public void beforeSwitchDs(RouteingDataSource routeingDataSource){
        DataSourceContextHolder.setDB(routeingDataSource.value());
    }


    @After("@annotation(routeingDataSource)")
    public void afterSwitchDs(RouteingDataSource routeingDataSource){
        DataSourceContextHolder.clearDB();
    }

}
