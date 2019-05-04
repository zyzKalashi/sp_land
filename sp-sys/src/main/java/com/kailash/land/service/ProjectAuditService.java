package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.ProjectAudit;
import com.kailash.land.filter.ProjectFiter;

public interface ProjectAuditService extends IService<ProjectAudit> {

	List<Map<String, Object>> selectProAuditList(ProjectFiter filter);

}
