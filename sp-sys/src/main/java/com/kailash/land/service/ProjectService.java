package com.kailash.land.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;

public interface ProjectService extends IService<Project> {

	
	PageInfo<Map<String, Object>> simpleList(ProjectFiter filter);

}
