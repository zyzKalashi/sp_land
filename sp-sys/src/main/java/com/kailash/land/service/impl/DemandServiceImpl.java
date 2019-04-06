package com.kailash.land.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Demand;
import com.kailash.land.mapper.DemandMapper;
import com.kailash.land.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {
	@Autowired
	private DemandMapper demandMapper;
	
	@Override
	public PageInfo<Map<String, Object>> selectDemandInfo(Demand demand) {
		PageHelper.startPage(demand.getPageNo(), demand.getPageSize());
		List<Map<String, Object>> result = this.demandMapper.selectDemandInfo(demand);
		return new PageInfo<>(result);
	}
	
	@Override
	public PageInfo<Map<String, Object>> simpleList(Demand filter) {
		PageHelper.startPage(filter.getPageNo(), filter.getPageSize());
		Page<Map<String, Object>> pageList = this.demandMapper.querySimpleList(filter);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);
		return pageInfo;
	}

}
