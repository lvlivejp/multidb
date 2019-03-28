package com.lvlivejp.multidb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = DataSources.MASTER_DB)
    @ConfigurationProperties("spring.datasource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = DataSources.SLAVE_DB)
    @ConfigurationProperties("spring.datasource-second")
    public DataSource dataSourceSecond(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

}
