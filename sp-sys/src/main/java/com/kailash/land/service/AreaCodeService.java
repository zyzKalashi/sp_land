package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.AreaCode;

public interface AreaCodeService extends IService<AreaCode> {

	List<AreaCode> initArea();

	List<Map<String, Object>> areaTree();

}
