package com.kailash.land.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.entity.Users;
import com.kailash.land.service.LoginLogService;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "/user")
public class UsersController extends AbstractController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private LoginLogService loginLogService;

	@ResponseBody
	@PostMapping(value = "/users_register")
	public Result register(Users user) {
		user.setUserStatus(StatusEnum.USER_NORMAL.getId());
		user.setCreateDate(new Date());
		int i = this.usersService.registerUser(user);
		if (i > 0) {
			return Result.ok();
		}
		return Result.error();
	}

	@RequestMapping(value = "users_addTownAdmin", method = RequestMethod.POST)
	public Result addTownAdmin(Users user) {
		user.setCreateUser(getUserId().intValue());
		user.setUpdateUser(getUserId().intValue());
		int i = this.usersService.registerUser(user);
		if (i > 0) {
			return Result.ok();
		}
		return Result.error();
	}

	@RequestMapping(value = "userDetail", method = RequestMethod.POST)
	public Result userDetail(Users user) {
		Users userData = this.usersService.selectById(user);
		userData.setPassword(null);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("userData", userData);

		EntityWrapper<LoginLog> ewLoginLog = new EntityWrapper<LoginLog>();
		ewLoginLog.setEntity(new LoginLog());
		ewLoginLog.where("userId = {0}", userData.getUserId());
		LoginLog loginLog = this.loginLogService.selectOne(ewLoginLog);
		returnMap.put("loginLog", loginLog);

		return Result.ok(returnMap);
	}
//
//	@ResponseBody
//	@PostMapping(value = "/users_checkNameOrPhone")
//	public Result usersCheckName(Users user) {
//		int flag = this.usersService.checkUserNameOrPhone(user);
//		return Result.ok().put("flag", flag);
//	}
//
//	@ResponseBody
//	@PostMapping(value = "/users_update")
//	public Result usersUpdate(Users user) {
//		this.usersService.updateUsers(user);
//		return Result.ok();
//	}

}
