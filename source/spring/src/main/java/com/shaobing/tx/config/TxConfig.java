package com.shaobing.tx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@EnableTransactionManagement
@ComponentScan("com.shaobing.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource datasource = new ComboPooledDataSource();
        datasource.setUser("root");
        datasource.setPassword("root");
        datasource.setDriverClass("com.mysql.jdbc.Driver");
        datasource.setJdbcUrl("jdbc:mysql://localhost:3306/shop");
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
//        这里调方法相当于给容器中找组件.spring会对@Configuration类特殊处理
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
