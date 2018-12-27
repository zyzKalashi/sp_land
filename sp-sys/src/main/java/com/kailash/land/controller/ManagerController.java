package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.HelpInfo;
import com.kailash.land.entity.TagInfo;
import com.kailash.land.service.HelpInfoService;
import com.kailash.land.service.TagInfoService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

	@Autowired
	private TagInfoService tagInfoService;

	@Autowired
	private HelpInfoService helpInfoService;

	@RequestMapping(value = "/tag/add", method = RequestMethod.POST)
	public Result tagAdd(TagInfo tagInfo) {
		try {
			if (tagInfo != null) {
				this.tagInfoService.instertTagInfo(tagInfo);
			} else {
				throw new Exception("param is wrong!");
			}
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}

	@RequestMapping(value = "/tag/update", method = RequestMethod.POST)
	public Result tagUpdate(TagInfo tagInfo) {
		try {
			if (tagInfo != null) {
				this.tagInfoService.updateTagInfo(tagInfo);
			} else {
				throw new Exception("param is wrong!");
			}
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}

	@RequestMapping(value = "/help/add", method = RequestMethod.POST)
	public Result helpAdd(HelpInfo helpInfo) {
		try {
			if (helpInfo != null) {
				this.helpInfoService.instertHelpInfo(helpInfo);
			} else {
				throw new Exception("param is wrong!");
			}
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}

	@RequestMapping(value = "/help/update", method = RequestMethod.POST)
	public Result helpUpdate(HelpInfo helpInfo) {
		try {
			if (helpInfo != null) {
				this.helpInfoService.updateHelpInfo(helpInfo);
			} else {
				throw new Exception("param is wrong!");
			}
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}

}
