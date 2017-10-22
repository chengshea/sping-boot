package com.cs.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.test.mapper.UserInfoMapper;
import com.cs.test.model.UserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="RW")
@RestController
public class TestController {

	
	@Autowired
	private UserInfoMapper userMapper;
	
//	@Autowired  
//	private TinUserService user;
	
	
	@ApiOperation(value = "1", notes = "test2")
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  select(@ApiParam("uiId")@RequestParam(value = "id", required = true)Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		 UserInfo info = userMapper.selectByEvenUserId(id);
		   map.put("status", 0);
			map.put("msg", "注册失败");
			map.put("data", info);
			return map;
		
		
	}
	
	@ApiOperation(value = "Odd", notes = "默认")
	@RequestMapping(value = "/select2", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  select2(@ApiParam("uiId")@RequestParam(value = "id", required = true)Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		 UserInfo info = userMapper.selectByOddUserId(id);
		   map.put("status", 0);
			map.put("msg", "注册失败");
			map.put("data", info);
			return map;
		
		
	}
	
	
//	@ApiOperation(value = "slave", notes = "test2")
//	@RequestMapping(value = "/tss", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object>  tss(@ApiParam("uiId")@RequestParam(value = "id", required = true)Integer id){
//		Map<String, Object> map = new HashMap<String, Object>();
//		 UserInfo info = user.slave(id);
//			map.put("data", info);
//			return map;
//		
//		
//	}
//	
//	@ApiOperation(value = "Odd", notes = "默认")
//	@RequestMapping(value = "/tsm", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object>  tsm(@ApiParam("uiId")@RequestParam(value = "id", required = true)Integer id){
//		Map<String, Object> map = new HashMap<String, Object>();
//		 UserInfo info = user.master(id);
//			map.put("data", info);
//			return map;
//		
//		
//	}
}
