package com.huyanqiu.springbootall.service;

import com.huyanqiu.springbootall.domain.User;
import com.huyanqiu.springbootall.domain.vo.SysResult;

public interface UserService {
	
	public User selectById(int id);

	public SysResult add(User user);

	public SysResult update(User user);
	
}
