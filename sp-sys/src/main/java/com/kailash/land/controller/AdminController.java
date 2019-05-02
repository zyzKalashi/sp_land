package com.kailash.land.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	/**
	 * 仪表盘页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dashbord", method = RequestMethod.GET)
	public ModelAndView toDashBord() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		return mav;
	}

	/**
	 * 用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/{page}", method = RequestMethod.GET)
	public ModelAndView toUserPage(@PathVariable("page") String page, String userId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/user/" + page);
		mav.addObject("userId", userId);
		return mav;
	}

	/**
	 * 新闻法规
	 * 
	 * @return
	 */
	@RequestMapping(value = "/notice/{page}", method = RequestMethod.GET)
	public ModelAndView toNoticePage(@PathVariable("page") String page, String noticeId, String noticeKind) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/notice/" + page);
		mav.addObject("noticeId", noticeId);
		mav.addObject("noticeKind", noticeKind);
		return mav;
	}

	/**
	 * 文档管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doc/{page}", method = RequestMethod.GET)
	public ModelAndView toDocPage(@PathVariable("page") String page, String docId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/doc/" + page);
		mav.addObject("docId", docId);
		return mav;
	}

	/**
	 * 项目管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/project/{page}", method = RequestMethod.GET)
	public ModelAndView toProjectPage(@PathVariable("page") String page, String projectId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/project/" + page);
		mav.addObject("projectId", projectId);
		return mav;
	}

	/**
	 * 需求管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/demand/{page}", method = RequestMethod.GET)
	public ModelAndView toDemandPage(@PathVariable("page") String page, String demandId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/demand/" + page);
		mav.addObject("demandId", demandId);
		return mav;
	}

	/**
	 * 页脚+合作+首页图片管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pic/{page}", method = RequestMethod.GET)
	public ModelAndView toPicPage(@PathVariable("page") String page, String picId, String picType) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/pic/" + page);
		mav.addObject("picId", picId);
		mav.addObject("picType", picType);
		return mav;
	}

	/**
	 * 地域管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/area/{page}", method = RequestMethod.GET)
	public ModelAndView toAreaPage(@PathVariable("page") String page, String areaId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/area/" + page);
		mav.addObject("areaId", areaId);
		return mav;
	}

}
