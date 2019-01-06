package com.kailash.land.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.DemandInfo;
import com.kailash.land.filter.DemandFilter;
import com.kailash.land.service.DemandInfoService;
import com.kailash.land.service.DemandKindService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "demand")
public class DemandController extends AbstractController{
	@Autowired
	private DemandInfoService demandInfoService;
	@Autowired
	private DemandKindService demandKindService;
	
	@RequestMapping(value = "demand_add", method = RequestMethod.POST)
	public Result dealAdd(DemandFilter filter) {
		try {
			DemandInfo demandInfo = new DemandInfo(filter); 
			demandInfo.setCreateUser(getUserId());
			demandInfo.setUpdateUser(getUserId());
			this.demandInfoService.instertDemandInfo(demandInfo);
			Integer demandInfoId = demandInfo.getPkid();
			
			List<Integer> demandKindList = filter.getDemandKindList();
			this.demandKindService.instertBatch(demandInfoId, demandKindList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}
	
}
