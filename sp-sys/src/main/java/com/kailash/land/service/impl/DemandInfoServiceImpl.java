//package com.kailash.land.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kailash.land.dao.DemandInfoMapper;
//import com.kailash.land.dao.DemandKindMapper;
//import com.kailash.land.entity.DemandInfo;
//import com.kailash.land.service.DemandInfoService;
//
//@Service
//public class DemandInfoServiceImpl implements DemandInfoService {
//	
//	@Autowired
//	private DemandInfoMapper demandInfoMapper;
//	
//	@Autowired
//	private DemandKindMapper demandKindMapper;
//
//	@Override
//	public int instertDemandInfo(DemandInfo demandInfo) {
//		return this.demandInfoMapper.insertSelective(demandInfo);
//	}
//
//}
