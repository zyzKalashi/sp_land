package com.kailash.land.service;

import java.util.Map;

import com.kailash.land.entity.Users;
import com.kailash.land.filter.UsersFilter;

/**
 * 系统用户
 */
public interface UsersService {

	Map<String, Object> getUserByUserId(Users user);

	void updateUsers(Users user);

	int checkUserNameOrPhone(Users user);

	Users queryByUserName(String username);

	int registerUser(Users user);


}
