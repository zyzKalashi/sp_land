package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.ProjectAudit;
import com.kailash.land.filter.ProjectFiter;

@Mapper
public interface ProjectAuditMapper extends BaseMapper<ProjectAudit> {

	List<Map<String, Object>> selectProAuditList(ProjectFiter filter);

}
