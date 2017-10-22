package com.cs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitClient {


	@Bean
	CustomOCR init(@Value("${OCR.APP_ID}")
	  String id,
	@Value("${OCR.API_KEY}")
	  String ak,
	@Value("${OCR.SECRET_KEY}")
	  String sk){
		CustomOCR client = new CustomOCR(id, ak, sk);
		return client;
		 
	}
}
