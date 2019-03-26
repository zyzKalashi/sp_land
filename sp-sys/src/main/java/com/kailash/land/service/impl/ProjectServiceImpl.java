package com.kailash.land.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.dao.ProjectMapper;
import com.kailash.land.entity.ProjectEntity;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {

	@Override
	public int instertProject(ProjectEntity projectEntity) {
		projectEntity.setDealNum("TX-" + DateUtils.format(new Date(), DateFormatConsts.DAY_HOUR_MINUTES) + "-100100");
		return this.baseMapper.insert(projectEntity);
	}

	@Override
	public List<Map<String, Object>> queryIndexNewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> queryIndexKindList(Integer kind) {
		// TODO Auto-generated method stub
		return null;
	}

}
