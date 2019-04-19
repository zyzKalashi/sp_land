package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.RoleEnum;
import com.kailash.land.entity.Users;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.ShiroUtils;

/**
 * @Author: zyz
 * @Date: Create in 2018/4/24
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

//	@Autowired
//	private RoleMapper roleMapper;

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

	public PageInfo<Users> selectUsersPage(Users user) {
		PageHelper.startPage(user.getPageNo(), user.getPageSize());
		EntityWrapper<Users> ewUsers = new EntityWrapper<Users>();
		ewUsers.setEntity(user);
		ewUsers.where(" user_status not in ('0','5') ");
		if (StringUtils.isNotEmpty(user.getFromPage())) {
			if (user.getFromPage().equals("common")) {
				ewUsers.where(" role_id = 4 ");
			} else if (user.getFromPage().equals("admin")) {
				if (ShiroUtils.getRoleId() == 1) {
					ewUsers.where(" role_id in (1, 2, 3) ");
				} else if (ShiroUtils.getRoleId() == 2) {
					ewUsers.where(" role_id in ( 2, 3) ");
				}
			}
		}
		ewUsers.orderBy(" role_id ASC, pkid DESC ");
		List<Users> users = usersMapper.selectList(ewUsers);
		return new PageInfo<>(users);
	}

	@Override
	public Users findByFiled(Map<String, Object> param) {
		return this.usersMapper.findByFiled(param);
	}

}
