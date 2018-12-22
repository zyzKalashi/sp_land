package com.kailash.land.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.UsersMapper;
import com.kailash.land.entity.Users;
import com.kailash.land.service.UsersService;

/**
 * @Author: zyz
 * @Date: Create in 2018/4/24
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public Map<String, Object> getUserByUserId(Users user) {
		return this.usersMapper.selectByUserId(user.getUserId());
	};

	@Override
	public void updateUsers(Users user) {
		this.usersMapper.updateByCondition(user);
	}

	@Override
	public int checkUserNameOrPhone(Users user) {
		user = this.usersMapper.findByUserName(user.getUserName());
		if (user != null && user.getUserId() != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public Users queryByUserName(String username) {
		return this.usersMapper.findByUserName(username);
	}

	@Override
	public int registerUser(Users user) {
		user = this.usersMapper.insert(user);
		return user.getUserId();
	}

}
