package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.Project;

public interface ProjectService extends IService<Project> {

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList(Integer kind);

}
