package com.kailash.land.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.NoticeInfo;
import com.kailash.land.service.NoticeInfoService;
import com.kailash.land.util.DateUtils;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "notice")
public class NoticeController extends AbstractController {
	@Autowired
	private NoticeInfoService noticeInfoService;

	@RequestMapping(value = "notice_add", method = RequestMethod.POST)
	public Result noticeAdd(NoticeInfo noticeInfo) {
		try {
			noticeInfo.setCreateUser(getUserId());
			noticeInfo.setUpdateUser(getUserId());
			noticeInfo.setCreateDate(DateUtils.parse(noticeInfo.getCreateDateStr(), "yyyy年MM月dd日"));
			noticeInfoService.instertNoticeInfo(noticeInfo);
			Map m = new HashMap();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}
}
