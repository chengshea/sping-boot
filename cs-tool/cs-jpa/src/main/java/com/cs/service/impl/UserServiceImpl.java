package com.cs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cs.model.CsUser;
import com.cs.repository.UserRepository;
import com.cs.service.UserService;
import com.cs.util.SnowflakeIdWorker;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SnowflakeIdWorker id;
	
	
	@Override
	public Long save(CsUser user){
		user.setId(id.nextId());
		CsUser su = userRepository.save(user);
		return su.getId();
	}
	
	
}
