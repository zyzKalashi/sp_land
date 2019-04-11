package com.kailash.land.controller;


import com.kailash.land.service.DashboardService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		mav.addObject("noticeId", noticeId);
		mav.setViewName("admin/notice/noticeModify");
		return mav;
	}
	
	/**
	 * 文档管理列表页面跳转
	 * @return
	 */
	@RequestMapping(value = "/docList", method = RequestMethod.GET)
	public ModelAndView toDocList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/doc/docList");
		return mav;
	}
	
	/**
	 * 文档管理修改页面跳转
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/docModify", method = RequestMethod.GET)
	public ModelAndView toDocModify(String docId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("docId", docId);
		mav.setViewName("admin/doc/docModify");
		return mav;
	}
	/**
	 * 项目审批列表页面跳转
	 * @return
	 */
	@RequestMapping(value = "/projectList", method = RequestMethod.GET)
	public ModelAndView toProjectList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/project/projectList");
		return mav;
	}
	
	/**
	 * 项目审批页面跳转
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "/projectAudit", method = RequestMethod.GET)
	public ModelAndView toProjectAudit(String projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectId", projectId);
		mav.setViewName("admin/project/projectAudit");
		return mav;
	}
	
	/**
	 * 需求审批列表页面跳转
	 * @return
	 */
	@RequestMapping(value = "/demandList", method = RequestMethod.GET)
	public ModelAndView toDemandList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/demand/demandList");
		return mav;
	}
	
	/**
	 * 需求审批页面跳转
	 * @param demandId
	 * @return
	 */
	@RequestMapping(value = "/demandAudit", method = RequestMethod.GET)
	public ModelAndView toDemandAudit(String demandId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("demandId", demandId);
		mav.setViewName("admin/demand/demandAudit");
		return mav;
	}
	
	/**
	 * 图片信息管理首页
	 * @return
	 */
	@RequestMapping(value = "/picIndex", method = RequestMethod.GET)
	public ModelAndView toPicIndex(String  picType) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("picType",picType);
		mav.setViewName("admin/picinfo/picIndex");
		return mav;
	}
	
	/**
	 * 图片信息管理修改
	 * @return
	 */
	@RequestMapping(value = "/picModify", method = RequestMethod.GET)
	public ModelAndView toPicModify() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/picinfo/picModify");
		return mav;
	}
}
