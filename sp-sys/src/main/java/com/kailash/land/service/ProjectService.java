package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;

import java.util.Map;

public interface ProjectService extends IService<Project> {
	PageInfo<Map<String, Object>> selectProjectInfo(ProjectFiter filter);

	PageInfo<Map<String, Object>> simpleList(ProjectFiter filter);

	Integer countByAreaCode(Integer id);

	PageInfo<Map<String, Object>> tableData(ProjectFiter param);

	String createExcel(ProjectFiter param);

}
