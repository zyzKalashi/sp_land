package com.kailash.land.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.Demand;

public interface DemandService extends IService<Demand> {

	PageInfo<Map<String, Object>> simpleList(Demand filter);

}
