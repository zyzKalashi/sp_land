package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.Project;
import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {


	@Override
	public List<Map<String, Object>> queryIndexNewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> queryIndexKindList(Integer kind) {
		// TODO Auto-generated method stub
		return null;
	}

}
