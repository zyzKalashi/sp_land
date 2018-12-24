package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.DealInfoMapper;
import com.kailash.land.entity.DealInfo;
import com.kailash.land.service.DealInfoService;

@Service
public class DealInfoServiceImpl implements DealInfoService {
	
	@Autowired
	private DealInfoMapper dealInfoMapper;

	@Override
	public DealInfo instertDealInfo(DealInfo dealInfo) {
		return this.dealInfoMapper.instert(dealInfo);
	}
	
	
	
	

}
