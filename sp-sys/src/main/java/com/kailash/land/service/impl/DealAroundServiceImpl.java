package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.DealAroundMapper;
import com.kailash.land.entity.DealAround;
import com.kailash.land.service.DealAroundService;

@Service
public class DealAroundServiceImpl implements DealAroundService {
	
	@Autowired
	private DealAroundMapper dealAroundMapper;
	
	@Override
	public DealAround instertDealAround(DealAround dealAround) {
		return this.dealAroundMapper.instert(dealAround);
	}
	
	
	
	

}
