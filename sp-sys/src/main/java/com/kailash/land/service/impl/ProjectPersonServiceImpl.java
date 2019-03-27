package com.kailash.land.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.ProjectPerson;
import com.kailash.land.mapper.ProjectPersonMapper;
import com.kailash.land.service.ProjectPersonService;

@Service
public class ProjectPersonServiceImpl extends ServiceImpl< ProjectPersonMapper, ProjectPerson> implements ProjectPersonService {

}
