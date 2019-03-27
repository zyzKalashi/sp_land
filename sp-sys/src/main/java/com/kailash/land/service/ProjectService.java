package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.ProjectEntity;

public interface ProjectService extends IService<ProjectEntity> {

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList(Integer kind);

}
