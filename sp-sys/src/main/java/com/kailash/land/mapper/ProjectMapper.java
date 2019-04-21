package com.kailash.land.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
	/**
	 * 后台列表查询
	 * 
	 * @param filter
	 * @return
	 */
	List<Map<String, Object>> selectProjectInfo(ProjectFiter filter);

	Page<Map<String, Object>> querySimpleList(@Param("pro") ProjectFiter filter);

	/**
	 * 项目统计
	 * 
	 * @return
	 */
	Map<String, String> projectStatistics();

	/**
	 * 项目明细统计
	 * 
	 * @return
	 */
	List<Map<String, String>> projectDetailStatistics();

	Integer countByAreaCode(@Param("areaCode") Integer id);

	List<Map<String, Object>> tableData(Map<String, Object> param);

}