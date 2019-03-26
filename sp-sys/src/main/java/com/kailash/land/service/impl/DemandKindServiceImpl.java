//package com.kailash.land.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kailash.land.dao.DemandKindMapper;
//import com.kailash.land.entity.DemandKind;
//import com.kailash.land.service.DemandKindService;
//
//@Service
//public class DemandKindServiceImpl implements DemandKindService {
//	@Autowired
//	private DemandKindMapper demandKindMapper;
//
//	@Override
//	public int instertBatch(Integer demandInfoId, List<Integer> demandKindList) {
//		if (demandKindList != null && demandKindList.size() > 0) {
//			for (Integer kind : demandKindList) {
//				this.demandKindMapper.insertSelective(new DemandKind(demandInfoId, kind));
//			}
//		}
//		return demandKindList.size();
//	}
//
//}
