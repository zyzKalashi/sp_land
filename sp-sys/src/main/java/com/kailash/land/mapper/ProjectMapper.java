package com.kailash.land.mapper;

import java.util.List;
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
	
	/**
	 * 项目统计
	 * @return
	 */
	Map<String,String> projectStatistics();
	
	/**
	 * 项目明细统计
	 * @return
	 */
	List<Map<String,String>> projectDetailStatistics();

}