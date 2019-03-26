package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "deal")
public class ProjectController extends AbstractController {

	@Autowired
	private ProjectService projectService;

//	@Autowired
//	private DealAroundService dealAroundService;
//
//	@Autowired
//	private DealPersonService dealPersonService;

	@RequestMapping(value = "deal_add", method = RequestMethod.POST)
	public Result dealAdd(ProjectFiter filter) {
//		try {
//			ProjectEntity di = new ProjectEntity(filter);
//			di.setCreateUser(getUserId());
//			di.setUpdateUser(getUserId());
//			this.projectService.instertProject(di);
//			
//			DealPerson dp = new DealPerson(filter);
//			dp.setDealInfoId(di.getPkid());
//			this.dealPersonService.instertDealPerson(dp);
//			
//			DealAround dealAround = new DealAround(filter);
//			dealAround.setDealInfoId(di.getPkid());
//			this.dealAroundService.instertDealAround(dealAround);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Result.error();
//		}
		return Result.ok();
	}

}
