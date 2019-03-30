package com.kailash.land.mapper;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.Users;


public interface UsersMapper extends BaseMapper<Users> {

	

	/**
	 * findByUserName登录用
	 *
	 * @param username
	 * @return
	 * @author zyz
	 */
	@SqlParser(filter = true)
	Users findByUserName(String username);

	



}