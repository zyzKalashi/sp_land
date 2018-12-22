package com.kailash.land.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.Users;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "url")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Result register(Users user) {
		int i = this.usersService.registerUser(user);
		if (i > 0) {
			return Result.ok();
		}
		return Result.error();
	}

	@RequestMapping(value = "detailUser", method = RequestMethod.POST)
	public Result detailUser(Users user) {
		Map<String, Object> userMap = usersService.getUserByUserId(user);
		return Result.ok().put("user", userMap);
	}

	@ResponseBody
	@PostMapping(value = "/users_checkNameOrPhone")
	public Result usersCheckName(Users user) {
		int flag = this.usersService.checkUserNameOrPhone(user);
		return Result.ok().put("flag", flag);
	}

	@ResponseBody
	@PostMapping(value = "/users_update")
	public Result usersUpdate(Users user) {
		this.usersService.updateUsers(user);
		return Result.ok();
	}

}
