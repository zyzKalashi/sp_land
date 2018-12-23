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

	/**
	 * 登录url
	 *
	 * @author zyz
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	/**
	 * 登录url
	 *
	 * @author zyz
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String jkindex() {
		return "deal_add";
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
