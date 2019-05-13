package com.kailash.land.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.RoleEnum;
import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.Project;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.entity.ProjectAudit;
import com.kailash.land.entity.ProjectPerson;
import com.kailash.land.entity.ProjectPic;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.service.AreaCodeService;
import com.kailash.land.service.ProjectAroundService;
import com.kailash.land.service.ProjectAuditService;
import com.kailash.land.service.ProjectPersonService;
import com.kailash.land.service.ProjectPicService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.BeanUtils;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;
import com.kailash.land.util.JsonUtil;
import com.kailash.land.util.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "project")
public class ProjectController extends AbstractController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectAroundService projectAroundService;

	@Autowired
	private ProjectPersonService projectPersonService;

	@Autowired
	private ProjectPicService projectPicService;

	@Autowired
	private ProjectAuditService projectAuditService;

	@Autowired
	private AreaCodeService areaCodeService;

	@Transactional
	@ResponseBody
	@PostMapping(value = "/projectAdd")
	public Result projectAdd(ProjectFiter filter) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		try {
			Project di = new Project(filter);
			di.setUpdateDate(new Date());
			di.setUpdateUser(getUserId().intValue());

			di.setCreateDate(new Date());
			di.setCreateUser(getUserId().intValue());
			di.setProjectNo("TX-" + DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN_MO) + "-100100");

			di.setProjectStatus(StatusEnum.COMMON_TOTOWN.getId());
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

	@SuppressWarnings("serial")
	@Transactional
	@ResponseBody
	@PostMapping(value = "/projectModify")
	public Result projectModify(ProjectFiter filter) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		try {
			if (filter.getProjectId() == null) {
				return Result.error();
			}
			var roleId = getRoleId();
			Project di = new Project(filter);
			di.setUpdateUser(getUserId().intValue());
			di.setUpdateDate(new Date());
			if (RoleEnum.TOWNADMIN.getRoleId() == roleId || RoleEnum.AREAADMIN.getRoleId() == roleId
					|| RoleEnum.SUPERADMIN.getRoleId() == roleId) {
				di.setAuditUser(getUserId().intValue());
				di.setAuditDate(new Date());
				if (di.getProjectStatus() == null) {
					if (RoleEnum.AREAADMIN.getRoleId() == getRoleId() || RoleEnum.SUPERADMIN.getRoleId() == roleId) {
						di.setProjectStatus(StatusEnum.COMMON_NORMAL.getId());
					} else {
						di.setProjectStatus(StatusEnum.COMMON_TOAREA.getId());
					}
				}

				this.projectAuditService.insert(new ProjectAudit() {
					{
						this.setAuditDate(new Date());
						this.setAuditUser(getUserId().intValue());
						this.setProjectId(di.getPkid());
						this.setProjectStatus(di.getProjectStatus());
						this.setRoleId(roleId);
					}
				});
			}
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

		PageInfo<Map<String, Object>> pageInfo = this.projectService.simpleList(filter);

		return Result.ok().put("pageInfo", pageInfo);
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
		if (aroundMap != null && aroundMap.size() > 0) {
			returnMap.putAll(aroundMap);
		}

		Wrapper<ProjectPerson> personWrapper = new EntityWrapper<ProjectPerson>(new ProjectPerson());
		personWrapper.where("project_id = {0}", filter.getProjectId());
		Map<String, Object> personMap = this.projectPersonService.selectMap(personWrapper);
		if (personMap != null && personMap.size() > 0) {
			returnMap.putAll(personMap);
		}

		Date createDate = (Date) projectMap.get("createDate");
		String createDateStr = DateUtils.format(createDate, DateFormatConsts.DATE_PATTERN);

		returnMap.put("createDateStr", createDateStr);

		this.areaCodeService.initArea().forEach(v -> {
			if (returnMap.containsKey("areaCode") && returnMap.get("areaCode") != null) {
				if (v.getCode().equals(Long.parseLong(returnMap.get("areaCode").toString()))) {
					returnMap.put("areaName", v.getAreaName());
					if (returnMap.containsKey("townCode") && returnMap.get("townCode") != null) {
						v.getChildAreas().forEach(c -> {
							if (c.getCode().equals(Long.parseLong(returnMap.get("townCode").toString()))) {
								returnMap.put("townName", c.getAreaName());
							}
						});
					}
				}
			}
		});

		return Result.ok().put("projectData", returnMap);
	}

	@ResponseBody
	@PostMapping(value = "/queryPreNext")
	public Result queryPreNext(ProjectFiter filter) {
		filter.setPageNo(1);
		filter.setPageSize(999999);

		PageInfo<Map<String, Object>> pageInfo = this.projectService.simpleList(filter);
		int index = 0;
		Project prePro = null, nextPro = null;

		List<Map<String, Object>> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (filter.getProjectId().equals(Long.parseLong(list.get(i).get("projectId").toString()))) {
					index = i;
					break;
				}
			}
		}
		if (index > 0) {
			prePro = this.projectService.selectById((Serializable) list.get(index - 1).get("projectId"));
		}
		if (index < list.size() - 1) {
			nextPro = this.projectService.selectById((Serializable) list.get(index + 1).get("projectId"));
		}

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("preProject", prePro);
		returnMap.put("nextProject", nextPro);

		return Result.ok(returnMap);
	}

	/**
	 * 后台查询项目信息
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping(value = "projectSearch", method = RequestMethod.POST)
	public Result projectSearch(ProjectFiter project) {
		if (getRoleId() == RoleEnum.AREAADMIN.getRoleId()) {
			project.setAreaCode(getUser().getAreaCode());
		} else if (getRoleId() == RoleEnum.TOWNADMIN.getRoleId()) {
			project.setTownCode(getUser().getTownCode());
		}
		PageInfo<Map<String, Object>> mapPageInfo = this.projectService.selectProjectInfo(project);
		return Result.ok().put("pageInfo", mapPageInfo);
	}

	/**
	 * 项目信息审批
	 * 
	 * @param project
	 * @return
	 */
	@SuppressWarnings("serial")
	@ResponseBody
	@PostMapping(value = "/projectAudit")
	public Result projectAudit(Project project) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		try {
			if (project.getPkid() == null || project.getProjectStatus() == null) {
				return Result.error("参数错误");
			}

			EntityWrapper<Project> ewProject = new EntityWrapper<Project>();
			ewProject.setEntity(new Project());
			ewProject.where("pkid = {0}", project.getPkid());
			this.projectService.update(new Project() {
				{
					this.setProjectStatus(project.getProjectStatus());
					this.setUpdateUser(getUserId().intValue());
					this.setUpdateDate(new Date());
					this.setAuditUser(getUserId().intValue());
					this.setAuditDate(new Date());
				}
			}, ewProject);

		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("系统异常");
		}
		return Result.ok();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "batchModify", method = RequestMethod.POST)
	public Result batchModify(Map<String, Object> param) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		if (!param.containsKey("projectIds") || param.get("projectIds") == null) {
			return Result.error("参数错误");
		}
		List<Long> projectIds = (List<Long>) param.get("projectIds");
		if (projectIds.size() < 1) {
			return Result.error("参数错误");
		}
		List<Project> projects = new ArrayList<Project>();
		for (Long id : projectIds) {
			if (param.containsKey("status") && param.get("status") != null) {
				projects.add(new Project(id, Integer.parseInt(param.get("status").toString())));
			}
		}
		this.projectService.updateBatchById(projects);

		return Result.ok();
	}

	@ResponseBody
	@PostMapping(value = "/tableData", produces = "application/json;charset=UTF-8")
	public Result tableData(ProjectFiter param) {
		log.info("--> project tableData begin");
		PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<Map<String, Object>>();
		try {
			mapPageInfo = this.projectService.tableData(param);
			log.info(JsonUtil.toJson(Result.ok().put("pageInfo", mapPageInfo)));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error");
			return Result.error("服务器错误");
		}
		log.info("--> project tableData end");
		return Result.ok().put("pageInfo", mapPageInfo);
	}

	@RequestMapping(value = "exportExcel", method = RequestMethod.POST)
	public Result exportExcel(ProjectFiter param) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		String url = this.projectService.createExcel(param);
		return Result.ok().put("fileUrl", url);
	}

	@RequestMapping(value = "proPicModify", method = RequestMethod.POST)
	public Result proPicModify(ProjectPic projectPic) {
		if (getUser() == null) {
			return Result.error("登录过期，请重新登录");
		}
		projectPic.setCreateDate(new Date());
		projectPic.setCreateUser(getUserId().intValue());
		this.projectPicService.insert(projectPic);
		return Result.ok();
	}

	@RequestMapping(value = "proPicList", method = RequestMethod.POST)
	public Result proPicList(ProjectPic projectPic) {
		Wrapper<ProjectPic> wrapper = new EntityWrapper<ProjectPic>();
		wrapper.where("project_id = {0}", projectPic.getProjectId());
		wrapper.where("pic_kind = {0}", projectPic.getPicKind());
		wrapper.orderBy("pkid DESC");

		var list = this.projectPicService.selectList(wrapper);
		return Result.ok().put("list", list);
	}

	@RequestMapping(value = "proAuditList", method = RequestMethod.POST)
	public Result proAuditList(ProjectFiter filter) {
		var list = this.projectAuditService.selectProAuditList(filter);
		return Result.ok().put("list", list);
	}

}
