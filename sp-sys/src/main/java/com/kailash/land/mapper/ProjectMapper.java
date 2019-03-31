package com.kailash.land.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

	Page<Map<String, Object>> querySimpleList(@Param("pro") ProjectFiter filter);

}