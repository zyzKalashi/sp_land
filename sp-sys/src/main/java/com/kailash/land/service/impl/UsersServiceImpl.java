package com.kailash.land.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.RoleEnum;
import com.kailash.land.entity.Users;
import com.kailash.land.mapper.RoleMapper;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zyz
 * @Date: Create in 2018/4/24
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private RoleMapper roleMapper;

//	@Override
//	public Map<String, Object> getUserByUserId(Users user) {
//		return this.usersMapper.selectByUserId(user.getPkid());
//	};
//
//	@Override
//	public void updateUsers(Users user) {
//		this.usersMapper.updateByCondition(user);
//	}
//
//	@Override
//	public int checkUserNameOrPhone(Users user) {
//		user = this.usersMapper.findByUserName(user.getUserName());
//		if (user != null && user.getPkid() != null) {
//			return 1;
//		}
//		return 0;
//	}
//
	@Override
	public Users queryByUserName(String username) {
		return this.baseMapper.findByUserName(username);
	}

	@Override
	public int registerUser(Users user) {
		user.setRoleId(RoleEnum.COMMON.getRoleId());
		this.baseMapper.insert(user);
		return user.getUserId().intValue();
	}
	
	public PageInfo<Users> selectUsersPage(Users user){
		PageHelper.startPage(user.getPageNo(), user.getPageSize());
		EntityWrapper<Users> ewUsers = new EntityWrapper<Users>();
		ewUsers.setEntity(user);
		ewUsers.where(" user_status not in ('0','5') ");
		List<Users> users = usersMapper.selectList(ewUsers);
		return new PageInfo<>(users);
	}
}
