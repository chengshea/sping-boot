package com.cs.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.dto.Message;
import com.cs.util.SendEmail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="tool",description="email")
@Controller
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private StringRedisTemplate  stringRedisTemplate;
	
	  @Resource(name="stringRedisTemplate")  
	  private ValueOperations<String,String>   valOperation;
	
	@ApiOperation(value = "发送验证码", notes = "邮箱发送验证码")
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	@ResponseBody
	public Message sendEmail(@RequestParam(value = "email", required = true) String email) {
		StringBuffer sb = new StringBuffer();
		Random ne = new Random();
		int num = ne.nextInt(9999 - 1000) + 1000;
		int i = email.indexOf("@");
		String str = new StringBuffer().append(email).replace(2, i, "*****").toString();
		logger.info("发送邮件");
		sb.append("<p>亲爱的用户").append(str).append(":</p>")
				.append("欢迎您使用<a href='http://www.baopinghui.com/' style='text-decoration : none '>Tinkle</a>!")
				.append("<br>").append("您的验证码为:").append("<p style='font-family:verdana;font-size:35px;'>").append(num)
				.append("</p>").append("<br>").append("<br>")
				.append("<p style='font-family:arial;color:red;font-size:20px;'>").append("此验证码将在1小时后失效")
				.append("</p>");
		
		String send = SendEmail.send(email, sb.toString());
		if(send!=null && !send.isEmpty()){
			logger.info("发送邮件成功 NO："+num);
			valOperation.set("email_code", num+"",60,TimeUnit.MINUTES);
			return new Message(200,send,"发送成功");
		}else{
			return new Message(400,"发送失败");
		}

	}
}
