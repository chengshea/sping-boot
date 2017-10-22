package com.cs.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.annotation.TargetDataSource;
import com.cs.test.mapper.UserInfoMapper;
import com.cs.test.model.UserInfo;


@Service
@Transactional
public class TinUserServiceImpl  {
	
	@Autowired
	private UserInfoMapper userMapper;

	

	public UserInfo  slave(Integer id){
		return userMapper.selectByEvenUserId(id);
	}
	@TargetDataSource("slave")

	public UserInfo  master(Integer id){
		return userMapper.selectByOddUserId(id);
	}
}
