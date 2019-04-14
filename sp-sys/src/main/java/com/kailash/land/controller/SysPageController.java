package com.kailash.land.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kailash.land.common.web.AbstractController;

/**
 * 系统页面视图
 */
@Controller
public class SysPageController extends AbstractController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index_browserError", method = RequestMethod.GET)
	public String indexBrowserError() {
		return "index_browserError";
	}
	
	@RequestMapping(value = "/html/{page}", method = RequestMethod.GET)
	public String htmlPage(@PathVariable("page")String page) {
		return "html/" + page;
	}
	
	@RequestMapping(value = "/login/{page}", method = RequestMethod.GET)
	public String loginPage(@PathVariable("page")String page) {
		return "login/" + page;
	}

	/**
	 * 用户管理模块
	 *
	 * @param url
	 * @return
	 * @author zyz
	 */
	@RequestMapping("users/{url}")
	public String usersManager(@PathVariable("url") String url) {
		return "users/" + url;
	}

	/**
	 * index管理模块
	 *
	 * @author zyz
	 * @param url
	 * @return
	 */
	@RequestMapping("index/{url}")
	public String indexManager(@PathVariable("url") String url) {
		return "index/" + url;
	}

}
