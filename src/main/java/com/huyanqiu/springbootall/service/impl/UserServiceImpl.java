package com.huyanqiu.springbootall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyanqiu.springbootall.domain.User;
import com.huyanqiu.springbootall.domain.vo.SysResult;
import com.huyanqiu.springbootall.mapper.UserMapper;
import com.huyanqiu.springbootall.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查找
	 */
	@Override
	public User selectById(int id) {
		User user = userMapper.selectById(id);
		return user;
	}

	/**
	 * 添加
	 */
	@Override
	public SysResult add(User user) {
		int count = userMapper.insert(user);
		if (count>0) {
			return SysResult.ok("成功");
		}
		return SysResult.ok("失败");
	}

	/**
	 * 更新
	 */
	@Override
	public SysResult update(User user) {
		int count = userMapper.update(user);
		if (count>0) {
			return SysResult.ok("成功");
		}
		return SysResult.ok("失败");
	}

}
