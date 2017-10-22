package com.cs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.dto.Message;

@ControllerAdvice
public class GlobalExceptionController {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	@ResponseBody
    @ExceptionHandler(Exception.class)
    public Message handleException(Exception e) {
      
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
        	return new Message(0, "", "服务器出错");
        }
        logger.error(msg);
		return new Message(0, "", "叫后台小哥查日志");
        
    }


}
