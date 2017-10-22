package com.cs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("com.cs.mapper")
public class OCRApplication {

	public static void main(String[] args) {
		SpringApplication.run(OCRApplication.class, args);
	}
}
