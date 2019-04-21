package com.kailash.land.service.impl;

import java.util.HashMap;
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
import com.kailash.land.util.Result;
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
	public Result checkUse(Users user) {
		Users userCheck = null;
		var param = new HashMap<String, Object>();
		if (user.getUserId() != null) {
			param.put("userId", user.getUserId());
		}
		param.put("filed", "user_name");
		param.put("value", user.getUserName());
		userCheck = this.usersMapper.findByFiled(param);
		if (userCheck != null) {
			return Result.error("用户名已被占用，请重新填写！");
		}
		param.put("filed", "mobile");
		param.put("value", user.getMobile());
		userCheck = this.usersMapper.findByFiled(param);
		if (userCheck != null) {
			return Result.error("手机号码已被占用，请重新填写！");
		}
		param.put("filed", "email");
		param.put("value", user.getEmail());
		userCheck = this.usersMapper.findByFiled(param);
		if (userCheck != null) {
			return Result.error("此邮箱已被占用，请重新填写！");
		}
		return Result.ok();
	}

}
