package com.kailash.land.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.RoleEnum;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.entity.RoleEntity;
import com.kailash.land.entity.Users;
import com.kailash.land.service.LoginLogService;
import com.kailash.land.service.RoleService;
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

		Result result = this.usersService.checkUse(user);
		if (!result.get("code").equals(0)) {
			return result;
		}
		if (user.getUserStatus() == null ) {
			user.setUserStatus(StatusEnum.COMMON_AUDIT.getId());
		}
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

		LoginLog loginLog = this.loginLogService.selectByUserId(userData.getUserId());
		if (null != loginLog) {
			loginLog.setLogDateStr(DateUtils.format(loginLog.getLogDate(), DateFormatConsts.DATE_PATTERN));
		}
		returnMap.put("loginLog", loginLog);

		return Result.ok(returnMap);
	}

	@RequestMapping(value = "userSearch", method = RequestMethod.POST)
	public Result userSearch(Users user) {
		if (getRoleId() == RoleEnum.AREAADMIN.getRoleId()) {
			user.setRoleId(RoleEnum.TOWNADMIN.getRoleId());
			user.setAreaCode(getUser().getAreaCode());
		}
		PageInfo<Users> pageInfo = this.usersService.selectUsersPage(user);
		return Result.ok().put("pageInfo", pageInfo);
	}

	@RequestMapping(value = "allRoles", method = RequestMethod.POST)
	public Result allRoles() {
		List<RoleEntity> allRoles = roleService.selectAllRoles();
		Map<String, Object> returnMap = new Hashtable<>();
		returnMap.put("result", allRoles);
		return Result.ok(returnMap);
	}

	@RequestMapping(value = "getUserStatus", method = RequestMethod.GET)
	public Result getUserStatus() {
		Map<String, String> status = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		status.put("0", "删除");
		status.put("1", "正常");
		status.put("2", "待审核");
		status.put("3", "拒绝");
		status.put("4", "结束");
		status.put("5", "禁用");
		returnMap.put("status", status);
		return Result.ok(returnMap);
	}

	@PostMapping(value = "/users_modify")
	public Result modify(Users user) {
		Result result = this.usersService.checkUse(user);
		if (!result.get("code").equals(0)) {
			return result;
		}
		user.setUpdateDate(new Date());
		user.setUpdateUser(getUserId().intValue());
		if (StringUtils.isNotEmpty(user.getFromPage()) && user.getFromPage().equals("audit")) {
			user.setAuditDate(new Date());
			user.setAuditUser(getUserId().intValue());
		}
		boolean zt = this.usersService.updateById(user);

		if (zt) {
			return Result.ok();
		}
		return Result.error();
	}

	@PostMapping(value = "/checkUser")
	public Result checkUser(Users user) {
		EntityWrapper<Users> ewUser = new EntityWrapper<>();
		ewUser.where("pkid={0}", user.getUserId());
		if (StringUtils.isNotEmpty(user.getPassword())) {
			ewUser.where("password={0}", user.getPassword());
		}
		Users oldUser = this.usersService.selectOne(ewUser);
		if (Objects.isNull(oldUser)) {
			return Result.error("密码错误");
		} else {
			return Result.ok();
		}

	}

}
