package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.ProjectAudit;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.mapper.ProjectAuditMapper;
import com.kailash.land.service.ProjectAuditService;

@Service
public class ProjectAuditServiceImpl extends ServiceImpl<ProjectAuditMapper, ProjectAudit>
		implements ProjectAuditService {

	@Autowired
	private ProjectAuditMapper projectAuditMapper;

	@Override
	public List<Map<String, Object>> selectProAuditList(ProjectFiter filter) {
		return projectAuditMapper.selectProAuditList(filter);
	}

}
