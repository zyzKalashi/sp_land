package com.kailash.land.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Users;

/**
 * 系统用户
 */
public interface UsersService extends IService<Users> {

	Users queryByUserName(String username);

	int registerUser(Users user);

	PageInfo<Users> selectUsersPage(Users user);

	Users findByFiled(Map<String, Object> param);

}
