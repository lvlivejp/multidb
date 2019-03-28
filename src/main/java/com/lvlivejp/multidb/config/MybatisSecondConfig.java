package com.lvlivejp.multidb.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.lvlivejp.multidb.seconddao",sqlSessionFactoryRef = "sqlSessionFactoryBeanSecond")
public class MybatisSecondConfig {

    @Autowired
    @Qualifier(DataSources.SLAVE_DB)
    private DataSource dataSource;

    @Bean("sqlSessionFactoryBeanSecond")
    @ConfigurationProperties("mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBeanSecond(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor()});
        return sqlSessionFactoryBean;
    }

    @Bean("dataSourceTransactionManagerSecond")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager= new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
