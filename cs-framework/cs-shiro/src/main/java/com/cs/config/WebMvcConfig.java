package com.cs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
* @Title: WebMvcConfig.java 
* @Description: 	解决 @AutoConfigureAfter 错误用法导致的问题
* @date 2017年10月19日 上午11:45:29 
* @version V1.0
 */
//@Configuration
public class WebMvcConfig /*extends WebMvcConfigurerAdapter */{

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}
