package com.kailash.land.controller;

import com.kailash.land.entity.Users;
import com.kailash.land.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView toUserPermit() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/user/userList");
		return mav;
	}
	
	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public ModelAndView toUserModify(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userModify");
		return mav;
	}
	
	@RequestMapping(value = "/userAudit", method = RequestMethod.GET)
	public ModelAndView toUserAudit(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userAudit");
		return mav;
	}
}
