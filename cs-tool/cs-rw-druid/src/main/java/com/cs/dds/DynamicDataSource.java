package com.cs.dds;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源实现类
 */

public class DynamicDataSource extends AbstractRoutingDataSource{
	
	
	 //本地线程共享对象
	private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
	
	
	public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
		super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSources));
        super.afterPropertiesSet();
	}

	//数据源路由，此方用于产生要选取的数据源逻辑名称
	@Override
	protected Object determineCurrentLookupKey() {
		//从共享线程中获取数据源名称
		return DynamicDataSource.getDataSource();
	}
	
	
	
	public static void putDataSource(String name) {
		THREAD_LOCAL.set(name);
	}

	public static String getDataSource() {
		return THREAD_LOCAL.get();
	}

	public static void removeDataSource() {
		THREAD_LOCAL.remove();
	}
	
}
