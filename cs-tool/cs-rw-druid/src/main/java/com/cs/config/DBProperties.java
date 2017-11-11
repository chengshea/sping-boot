package com.cs.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;



import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.cs.constant.DataSourceType;
import com.cs.dds.DynamicDataSource;

/**
 * 实际数据源配置
 */

@Configuration
public class DBProperties {
	
	
	    @Bean
	    @ConfigurationProperties("spring.datasource.master")
	    public DataSource firstDataSource() {
	        return DruidDataSourceBuilder.create().build();
	    }

	    @Bean
	    @ConfigurationProperties("spring.datasource.slave")
	    public DataSource secondDataSource() {
	        return DruidDataSourceBuilder.create().build();
	    }

	    @Bean
	    @Primary
	    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
	        Map<String, DataSource> targetDataSources = new HashMap<>();
	        targetDataSources.put(DataSourceType.MASTER, firstDataSource);
	        targetDataSources.put(DataSourceType.SLAVE, secondDataSource);
	        return new DynamicDataSource(firstDataSource, targetDataSources);
	    }
	
	
}
