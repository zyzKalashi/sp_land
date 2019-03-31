package com.kailash.land.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	@Override
	public PageInfo<Map<String, Object>> simpleList(ProjectFiter filter) {
		PageHelper.startPage(filter.getPageNo(), filter.getPageSize());
		Page<Map<String, Object>> pageList =this.projectMapper.querySimpleList(filter);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);
		
		return pageInfo;
	}

}
