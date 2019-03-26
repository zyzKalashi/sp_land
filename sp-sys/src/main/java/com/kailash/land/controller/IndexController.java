package com.kailash.land.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.service.NoticeInfoService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "index")
public class IndexController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private NoticeInfoService noticeInfoService;

	@ResponseBody
	@GetMapping("dealInfoList_new")
	public Result dealInfoList_new() {
		List<Map<String, Object>> dealInfoList = this.projectService.queryIndexNewList();
		return Result.ok().put("dealInfoList", dealInfoList);
	}

	@ResponseBody
	@GetMapping("dealInfoList_kind")
	public Result dealInfoList_kind(Integer kind) {
		if (kind == null) {
			return Result.error();
		}
		List<Map<String, Object>> dealInfoList = this.projectService.queryIndexKindList(kind);
		return Result.ok().put("dealInfoList", dealInfoList);
	}

	@ResponseBody
	@GetMapping("noticeList")
	public Result noticeList() {
		List<Map<String, Object>> noticeList = this.noticeInfoService.queryIndexList();
		return Result.ok().put("noticeList", noticeList);
	}
}
