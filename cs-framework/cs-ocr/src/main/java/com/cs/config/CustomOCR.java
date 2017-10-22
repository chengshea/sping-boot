package com.cs.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.aip.ocr.AipOcr;

public class CustomOCR {
	 final Logger       logger = LoggerFactory.getLogger(CustomOCR.class);
	 private static AipOcr client;
	
	

	public CustomOCR(String id, String ak, String sk) {
		logger.info(ak+"=====初始化===="+sk);
		client = new AipOcr(id, ak, sk);
	}
    
	public static  AipOcr  client(){
		return client;
	}
    
}
