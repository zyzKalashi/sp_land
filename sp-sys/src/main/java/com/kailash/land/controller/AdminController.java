package com.kailash.land.controller;


import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.service.DashboardService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private DashboardService dashboardService;
	
	/**
	 * 仪表盘页面跳转
	 * @return
	 */
	@RequestMapping(value = "/dashbord", method = RequestMethod.GET)
	public ModelAndView toDashBord() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		return mav;
	}
	
	/**
	 * 获取仪表盘数据
	 * @return
	 */
	@PostMapping(value = "/getDashBordData")
	public Result getDashBordData(){
		try {
			return Result.ok(dashboardService.getDashboardData());
		} catch (Exception e){
			e.printStackTrace();
			return Result.error("获取初始化数据失败");
		}
	}
	
	/**
	 * 用户维护列表页面跳转
	 * @return
	 */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView toUserList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/user/userList");
		return mav;
	}
	
	/**
	 * 用户信息修改页面跳转
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public ModelAndView toUserModify(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userModify");
		return mav;
	}
	
	/**
	 * 用户信息审核页面跳转
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/userAudit", method = RequestMethod.GET)
	public ModelAndView toUserAudit(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userAudit");
		return mav;
	}
	
	/**
	 * 新闻法规列表页面跳转
	 * @return
	 */
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public ModelAndView toNoticeList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/notice/noticeList");
		return mav;
	}
	
	/**
	 * 新闻法规修改页面跳转
	 * @param noticeId
	 * @return
	 */
	@RequestMapping(value = "/noticeModify", method = RequestMethod.GET)
	public ModelAndView toNoticeModify(String noticeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", noticeId);
		mav.setViewName("admin/notice/noticeModify");
		return mav;
	}
}
