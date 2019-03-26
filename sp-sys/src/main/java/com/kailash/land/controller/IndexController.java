package com.kailash.land.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "index")
public class IndexController {

//	@Autowired
//	private ProjectService projectService;
//	@Autowired
//	private NoticeInfoService noticeInfoService;

//	@ResponseBody
//	@GetMapping("dealInfoList_new")
//	public Result dealInfoList_new() {
//		List<Map<String, Object>> dealInfoList = this.projectService.queryIndexNewList();
//		return Result.ok().put("dealInfoList", dealInfoList);
//	}
//
//	@ResponseBody
//	@GetMapping("dealInfoList_kind")
//	public Result dealInfoList_kind(Integer kind) {
//		if (kind == null) {
//			return Result.error();
//		}
//		List<Map<String, Object>> dealInfoList = this.projectService.queryIndexKindList(kind);
//		return Result.ok().put("dealInfoList", dealInfoList);
//	}
//
//	@ResponseBody
//	@GetMapping("noticeList")
//	public Result noticeList() {
//		List<Map<String, Object>> noticeList = this.noticeInfoService.queryIndexList();
//		return Result.ok().put("noticeList", noticeList);
//	}
}
