package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.entity.VisitLog;
import com.kailash.land.service.LoginLogService;
import com.kailash.land.service.VisitLogService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "sysLog")
public class SysLogController extends AbstractController {

	@Autowired
	private VisitLogService visitLogService;

	@Autowired
	private LoginLogService loginLogService;

	@ResponseBody
	@PostMapping(value = "/addVisitLog")
	public Result addVisitLog(VisitLog visitLog) {

		Integer visitNum = this.visitLogService.insertOrUpdateByBizId(visitLog);

		return Result.ok().put("visitNum", visitNum);
	}

	@ResponseBody
	@GetMapping(value = "/addLoginLog")
	public Result addLoginLog() {
		this.loginLogService.insertOrUpdateByUserId(new LoginLog(getUserId()));
		return Result.ok();
	}

}
