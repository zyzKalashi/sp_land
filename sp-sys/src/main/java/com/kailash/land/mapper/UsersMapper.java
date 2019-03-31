package com.kailash.land.mapper;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.Users;

import java.util.HashMap;
import java.util.Map;


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
	
	/**
	 * 注册会员统计
	 * @return
	 */
	Map<String, String> userStatistics();
}