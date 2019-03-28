package com.kailash.land.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.ProjectAround;
import com.kailash.land.mapper.ProjectAroundMapper;
import com.kailash.land.service.ProjectAroundService;

@Service
public class ProjectAroundServiceImpl extends ServiceImpl<ProjectAroundMapper, ProjectAround>
		implements ProjectAroundService {

}
