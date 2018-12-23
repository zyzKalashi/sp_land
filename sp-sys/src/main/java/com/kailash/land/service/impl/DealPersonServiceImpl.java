package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.DealPersonMapper;
import com.kailash.land.entity.DealPerson;
import com.kailash.land.service.DealPersonService;

@Service
public class DealPersonServiceImpl implements DealPersonService {
	
	@Autowired
	private DealPersonMapper dealPersonMapper;
	@Override
	public int insterDealPerson(DealPerson dp) {
		
		return this.dealPersonMapper.inster(dp);
	}
	
	
	
	

}
