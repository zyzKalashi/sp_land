package com.kailash.land.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.Project;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.entity.ProjectPerson;
import com.kailash.land.entity.Users;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.service.ProjectAroundService;
import com.kailash.land.service.ProjectPersonService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.BeanUtils;
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

	@Transactional
	@ResponseBody
	@PostMapping(value = "/projectAdd")
	public Result projectAdd(ProjectFiter filter) {
		try {
			Project di = new Project(filter);
			di.setUpdateDate(new Date());
			di.setUpdateUser(getUserId().intValue());

			di.setCreateDate(new Date());
			di.setCreateUser(getUserId().intValue());
			di.setProjectNo("TX-" + DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN_MO) + "-100100");

			di.setProjectStatus(StatusEnum.COMMON_AUDIT.getId());
			this.projectService.insertOrUpdate(di);

			ProjectPerson dp = new ProjectPerson(filter);
			dp.setProjectId(di.getPkid());
			this.projectPersonService.insertOrUpdate(dp);

			ProjectAround projectAround = new ProjectAround(filter);
			projectAround.setProjectId(di.getPkid());
			this.projectAroundService.insertOrUpdate(projectAround);

		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@Transactional
	@ResponseBody
	@PostMapping(value = "/projectModify")
	public Result projectModify(ProjectFiter filter) {
		try {
			if (filter.getProjectId() == null) {
				return Result.error();
			}

			Project di = new Project(filter);
			di.setUpdateUser(getUserId().intValue());
			di.setUpdateDate(new Date());
			EntityWrapper<Project> ewProject = new EntityWrapper<Project>();
			ewProject.setEntity(new Project());
			ewProject.where("pkid = {0}", di.getPkid());
			this.projectService.update(di, ewProject);

			EntityWrapper<ProjectPerson> ewProjectPerson = new EntityWrapper<ProjectPerson>();
			ewProjectPerson.setEntity(new ProjectPerson());
			ewProjectPerson.where("project_id = {0}", di.getPkid());
			ProjectPerson dp = new ProjectPerson(filter);
			if (BeanUtils.allfieldIsNUll(dp)) {
				this.projectPersonService.update(dp, ewProjectPerson);
			}

			EntityWrapper<ProjectAround> ewProjectAround = new EntityWrapper<ProjectAround>();
			ewProjectAround.setEntity(new ProjectAround());
			ewProjectAround.where("project_id = {0}", di.getPkid());
			ProjectAround projectAround = new ProjectAround(filter);
			if (BeanUtils.allfieldIsNUll(projectAround)) {
				this.projectAroundService.update(projectAround, ewProjectAround);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@ResponseBody
	@PostMapping(value = "/simpleList")
	public Result simpleList(ProjectFiter filter) {

		PageInfo<Map<String, Object>> pageList = this.projectService.simpleList(filter);

		return Result.ok().put("pageList", pageList);
	}

	@ResponseBody
	@PostMapping(value = "/queryDetail")
	public Result queryDetail(ProjectFiter filter) {
		if (filter.getProjectId() == null) {
			return Result.error();
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();

		Wrapper<Project> eWrapper = new EntityWrapper<Project>(new Project());
		eWrapper.where("project_status != 0 AND pkid = {0}", filter.getProjectId());
		Map<String, Object> projectMap = this.projectService.selectMap(eWrapper);

		returnMap.putAll(projectMap);

		Wrapper<ProjectAround> aroundWrapper = new EntityWrapper<ProjectAround>(new ProjectAround());
		aroundWrapper.where("project_id = {0}", filter.getProjectId());
		Map<String, Object> aroundMap = this.projectAroundService.selectMap(aroundWrapper);

		returnMap.putAll(aroundMap);

		Wrapper<ProjectPerson> personWrapper = new EntityWrapper<ProjectPerson>(new ProjectPerson());
		personWrapper.where("project_id = {0}", filter.getProjectId());
		Map<String, Object> personMap = this.projectPersonService.selectMap(personWrapper);

		returnMap.putAll(personMap);

		Date createDate = (Date) projectMap.get("createDate");
		String createDateStr = DateUtils.format(createDate, DateFormatConsts.DATE_PATTERN);

		returnMap.put("createDateStr", createDateStr);

		return Result.ok().put("projectData", returnMap);
	}

}
