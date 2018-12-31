package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.kailash.land.entity.DealInfo;

public interface DealInfoService {

	int instertDealInfo(DealInfo dealInfo);

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList(Integer kind);

}
