package com.huyanqiu.springbootall.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.huyanqiu.springbootall.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE id=#{id}")
	public User selectById(int id);

	@Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
	public int insert(User user);

	@Update("UPDATE user SET username=#{username}, password=#{password} WHERE id=#{id}")
	public int update(User user);
}
