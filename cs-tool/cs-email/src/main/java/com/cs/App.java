package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.cs.util.SendEmail;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class App {
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
    
    
    @Bean
    public SendEmail  send(){
    	return  new SendEmail();
    }
}
