package com.kailash.land.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.Project;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.entity.ProjectPerson;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.service.ProjectAroundService;
import com.kailash.land.service.ProjectPersonService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;
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

	@ResponseBody
	@PostMapping(value = "/project_add")
	public Result projectAdd(ProjectFiter filter) {
		try {
			Project di = new Project(filter);
			di.setCreateDate(new Date());
			di.setUpdateDate(new Date());
			di.setCreateUser(getUserId().intValue());
			di.setUpdateUser(getUserId().intValue());
			di.setProjectNo("TX-" + DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN_MO) + "-100100");
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

	@ResponseBody
	@PostMapping(value = "/project_modify")
	public Result projectModify(ProjectFiter filter) {
		try {
			if (filter.getProjectId() == null) {
				return Result.error();
			}
			Project di = new Project(filter);
			di.setUpdateUser(getUserId().intValue());
			this.projectService.updateAllColumnById(di);

			EntityWrapper<ProjectPerson> ewProjectPerson = new EntityWrapper<ProjectPerson>();
			ewProjectPerson.setEntity(new ProjectPerson());
			ewProjectPerson.where("project = {0}", di.getPkid());
			ProjectPerson dp = new ProjectPerson(filter);
			this.projectPersonService.update(dp, ewProjectPerson);

			EntityWrapper<ProjectAround> ewProjectAround = new EntityWrapper<ProjectAround>();
			ewProjectAround.setEntity(new ProjectAround());
			ewProjectAround.where("project = {0}", di.getPkid());
			ProjectAround projectAround = new ProjectAround(filter);
			this.projectAroundService.update(projectAround, ewProjectAround);

		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

}
