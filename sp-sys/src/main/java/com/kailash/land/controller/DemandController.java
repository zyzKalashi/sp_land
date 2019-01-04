package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.DemandInfo;
import com.kailash.land.service.DemandInfoService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "demand")
public class DemandController {
	@Autowired
	private DemandInfoService demandInfoService;
	
	@RequestMapping(value = "deal_add", method = RequestMethod.POST)
	public Result dealAdd(DemandInfo demandInfo) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}
	
}
