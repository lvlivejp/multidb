package com.lvlivejp.multidb.annotation;

import com.lvlivejp.multidb.config.DataSources;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RouteingDataSource {
    String value() default DataSources.MASTER_DB;
}
