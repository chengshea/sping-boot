package com.cs.config;


import com.zaxxer.hikari.HikariDataSource;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



/**
 * 实际数据源配置
 */


@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DBProperties {
	
	
	private HikariDataSource master;
	private HikariDataSource slave;
	
	
	public HikariDataSource getMaster() {
		return master;
	}
	
	
	public HikariDataSource getSlave() {
		return slave;
	}


	public void setMaster(HikariDataSource master) {
		this.master = master;
	}


	public void setSlave(HikariDataSource slave) {
		this.slave = slave;
	}
	

	
	
	
	

	
}
