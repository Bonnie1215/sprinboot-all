package com.huyanqiu.springbootall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.huyanqiu.springbootall.domain.base.User;
import com.huyanqiu.springbootall.util.MyMapper;

public interface UserMapper extends MyMapper<User> {
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	public User selectById(int id);

	@Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
	public int insert(User user);

	@Update("UPDATE user SET username=#{username}, password=#{password} WHERE id=#{id}")
	public int update(User user);

	@Select("SELECT * FROM user")
	public List<User> list();
	
}