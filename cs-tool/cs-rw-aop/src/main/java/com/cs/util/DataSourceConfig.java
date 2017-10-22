package com.cs.util;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import com.cs.dds.DynamicDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 */
@Configuration
@EnableScheduling
public class DataSourceConfig {

	@Autowired
	private DBProperties properties;

	private  static final String  MASTER="master";
	private  static final String  SLAVE="slave";
	
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		//按照目标数据源名称和目标数据源对象的映射存放在Map中
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(MASTER, properties.getMaster());
		targetDataSources.put(SLAVE, properties.getSlave());
		//采用 AbstractRoutingDataSource 的对象包装多数据源
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		//设置默认的数据源
		dataSource.setDefaultTargetDataSource(properties.getMaster());
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
