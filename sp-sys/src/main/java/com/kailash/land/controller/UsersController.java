package com.kailash.land.controller;

import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.RoleEntity;
import com.kailash.land.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.entity.Users;
import com.kailash.land.service.LoginLogService;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "/user")
public class UsersController extends AbstractController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private LoginLogService loginLogService;
	
	@Autowired
	private RoleService roleService;

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
		ewLoginLog.where("user_id = {0}", userData.getUserId());
		LoginLog loginLog = this.loginLogService.selectOne(ewLoginLog);
		if(null != loginLog){
			loginLog.setLogDateStr(DateUtils.format(loginLog.getLogDate(), DateFormatConsts.DATE_PATTERN));
		}
		returnMap.put("loginLog", loginLog);

		return Result.ok(returnMap);
	}
	
	@RequestMapping(value = "userSearch", method = RequestMethod.POST)
	public Result userSearch(Users user, Integer pageNum, Integer pageSize) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		PageInfo<Users> result = this.usersService.selectUsersPage(user, pageNum, pageSize);
		returnMap.put("result", result);
		return Result.ok(returnMap);
	}
	
	@RequestMapping(value = "allRoles", method = RequestMethod.POST)
	public Result allRoles(){
		List<RoleEntity> allRoles = roleService.selectAllRoles();
		Map<String, Object> returnMap = new Hashtable<>();
		returnMap.put("result", allRoles);
		return Result.ok(returnMap);
	}
	
	@RequestMapping(value = "getUserStatus", method = RequestMethod.GET)
	public Result getUserStatus(){
		Map<String,String> status = new HashMap<>();
		Map<String, Object> returnMap = new Hashtable<>();
		status.put("0", "正常");
		status.put("1", "禁用");
		status.put("2", "删除");
		status.put("3", "待审核");
		status.put("4", "拒绝");
		returnMap.put("status",status);
		return Result.ok(returnMap);
	}
	
	@PostMapping(value = "/users_modify")
	public Result modify(Users user) {
		EntityWrapper<Users> ewUser = new EntityWrapper<>();
		ewUser.setEntity(new Users());
		ewUser.where(" pkid = {0} ", user.getUserId());
		boolean zt = this.usersService.update(user, ewUser);
		if (zt) {
			return Result.ok();
		}
		return Result.error();
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
