package com.huyanqiu.springbootall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huyanqiu.springbootall.domain.base.User;
import com.huyanqiu.springbootall.domain.vo.SysResult;
import com.huyanqiu.springbootall.service.UserService;

/**
 * 测试集成mybatis
 * @author huyanqiu
 * @date 2018年5月10日下午3:20:59
 * @version 版本号：1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/select")
	public SysResult select(@RequestBody User user) {
		User selectUser = userService.selectById(user.getId());
		return SysResult.ok(selectUser);
	}
	
	@RequestMapping("/add")
	public SysResult add(@RequestBody User user) {
		return userService.add(user);
	}

	@RequestMapping("/update")
	public SysResult update(@RequestBody User user) {
		return userService.update(user);
	}
	
}
