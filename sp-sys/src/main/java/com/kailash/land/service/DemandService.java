package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Demand;

import java.util.Map;

public interface DemandService extends IService<Demand> {
	PageInfo<Map<String, Object>> selectDemandInfo(Demand demand);

	PageInfo<Map<String, Object>> simpleList(Demand filter);

}
