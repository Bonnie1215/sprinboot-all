package com.huyanqiu.springbootall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyanqiu.springbootall.domain.User;
import com.huyanqiu.springbootall.mapper.UserMapper;
import com.huyanqiu.springbootall.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User selectById(int id) {
		User user = userMapper.selectById(id);
		return user;
	}

}
