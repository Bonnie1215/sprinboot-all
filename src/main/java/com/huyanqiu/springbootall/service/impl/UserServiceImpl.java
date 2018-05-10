package com.huyanqiu.springbootall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyanqiu.springbootall.domain.base.User;
import com.huyanqiu.springbootall.domain.dto.UserDto;
import com.huyanqiu.springbootall.domain.vo.SysResult;
import com.huyanqiu.springbootall.domain.vo.SysResultByPage;
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

	/**
	 * 分页查询
	 */
	@Override
	public SysResult list(UserDto userDto) {
		PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
		List<User> userList = userMapper.list();
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		return SysResultByPage.ok(pageInfo.getList(), pageInfo.getTotal());
	}

}
