package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cs.util.SnowflakeIdWorker;


/**
 * 
* @Title: App.java 
* @Description: jpa自动建表 
* @author cs 
* @date 2017年10月19日 下午4:42:31 
* @version V1.0
 */
@SpringBootApplication
public class App 
{
	public static void main(String[] args) {
		 SpringApplication.run(App.class, args);
	}
	
	@Bean 
	public SnowflakeIdWorker  get(){
		return new SnowflakeIdWorker(0,0);
	}
}
