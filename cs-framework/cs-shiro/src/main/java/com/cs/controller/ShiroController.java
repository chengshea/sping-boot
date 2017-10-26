package com.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.dto.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="测试")
@Controller
public class ShiroController {

	 
	   @ApiOperation(value="测试",notes="一般识别")
	   @RequestMapping(name="/shiro",method=RequestMethod.POST)
	   @ResponseBody
	   public  Message  test(@ApiParam(value="字符串")
       @RequestParam(value="str",defaultValue="t")String str){
		   
		     return null;
		   
	   }
}
