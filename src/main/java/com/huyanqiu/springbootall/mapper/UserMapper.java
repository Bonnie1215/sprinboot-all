package com.huyanqiu.springbootall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.huyanqiu.springbootall.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE id=#{id} limit 1")
	public User selectById(int id);
}
