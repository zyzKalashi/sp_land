package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.Users;

/**
 * 系统用户
 */
public interface UsersService extends IService<Users> {
//
//	Map<String, Object> getUserByUserId(Users user);
//
//	void updateUsers(Users user);
//
//	int checkUserNameOrPhone(Users user);

	Users queryByUserName(String username);

	int registerUser(Users user);


}
