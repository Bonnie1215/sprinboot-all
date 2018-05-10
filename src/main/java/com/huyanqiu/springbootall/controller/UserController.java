package com.huyanqiu.springbootall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huyanqiu.springbootall.domain.User;
import com.huyanqiu.springbootall.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/select")
	public User select(@RequestBody User user) {
		User selectUser = userService.selectById(user.getId());
		return selectUser;
	}
	
}
