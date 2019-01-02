package com.kailash.land.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.common.enums.RoleEnum;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.dao.UsersMapper;
import com.kailash.land.entity.Users;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

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
		return this.usersMapper.selectByUserId(user.getPkid());
	};

	@Override
	public void updateUsers(Users user) {
		this.usersMapper.updateByCondition(user);
	}

	@Override
	public int checkUserNameOrPhone(Users user) {
		user = this.usersMapper.findByUserName(user.getUserName());
		if (user != null && user.getPkid() != null) {
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
		user.setUserStatus(StatusEnum.USER_NORMAL.getId());
		user.setRoleId(RoleEnum.COMMON.getRoleId());
		this.usersMapper.instertEntity(user);
		return user.getPkid();
	}

}
