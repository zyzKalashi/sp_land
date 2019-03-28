package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.Project;

@Mapper
public interface ProjectMapper extends BaseMapper<Project>{

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList();

}