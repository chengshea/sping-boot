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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="rw",description="读写")
@RestController
public class TestController {

	
	@Autowired
	private UserInfoMapper userMapper;
	
	
	
	@ApiOperation(value = "测试主从", notes = "主从库放不同数据测试")
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  test(@ApiParam(value="uiId",required = true)@RequestParam(value = "id",defaultValue="1")Integer id){
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("master", userMapper.selectUserIdMaster(id));

		map.put("slave", userMapper.selectUserIdSalve(id));
			
		
		 return map;
		
		
	}
	

}
