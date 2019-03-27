package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.entity.ProjectEntity;
import com.kailash.land.entity.ProjectPerson;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.service.ProjectAroundService;
import com.kailash.land.service.ProjectPersonService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "project")
public class ProjectController extends AbstractController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectAroundService projectAroundService;

	@Autowired
	private ProjectPersonService projectPersonService;

	@RequestMapping(value = "project_add", method = RequestMethod.POST)
	public Result projectAdd(ProjectFiter filter) {
		try {
			ProjectEntity di = new ProjectEntity(filter);
			di.setCreateUser(getUserId());
			di.setUpdateUser(getUserId());
			this.projectService.insert(di);
			
			ProjectPerson dp = new ProjectPerson(filter);
			dp.setProjectId(di.getPkid());
			
			
			this.projectPersonService.insert(dp);
			
			ProjectAround projectAround = new ProjectAround(filter);
			projectAround.setProjectId(di.getPkid());
			this.projectAroundService.insert(projectAround);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

}
