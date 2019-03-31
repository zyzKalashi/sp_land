package com.kailash.land.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.Demand;
import com.kailash.land.mapper.DemandMapper;
import com.kailash.land.service.DemandService;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {

}
