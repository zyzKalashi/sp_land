package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.kailash.land.entity.ProjectEntity;

public interface ProjectService {

	int instertProject(ProjectEntity projectEntity);

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList(Integer kind);
	
	

}
