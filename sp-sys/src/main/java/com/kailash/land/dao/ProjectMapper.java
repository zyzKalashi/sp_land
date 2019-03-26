package com.kailash.land.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.ProjectEntity;

@Mapper
public interface ProjectMapper extends BaseMapper<ProjectEntity>{

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList();

}