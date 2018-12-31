package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.DealAround;
import com.kailash.land.entity.DealInfo;
import com.kailash.land.entity.DealPerson;
import com.kailash.land.filter.DealFiter;
import com.kailash.land.service.DealAroundService;
import com.kailash.land.service.DealInfoService;
import com.kailash.land.service.DealPersonService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "deal")
public class DealController extends AbstractController {

	@Autowired
	private DealInfoService dealInfoService;

	@Autowired
	private DealAroundService dealAroundService;

	@Autowired
	private DealPersonService dealPersonService;

	@RequestMapping(value = "deal_add", method = RequestMethod.POST)
	public Result dealAdd(DealFiter filter) {
		try {
			DealInfo di = new DealInfo(filter);
			di.setCreateUser(getUserId());
			di.setUpdateUser(getUserId());
			this.dealInfoService.instertDealInfo(di);
			
			DealPerson dp = new DealPerson(filter);
			dp.setDealInfoId(di.getPkid());
			this.dealPersonService.instertDealPerson(dp);
			
			DealAround dealAround = new DealAround(filter);
			dealAround.setDealInfoId(di.getPkid());
			this.dealAroundService.instertDealAround(dealAround);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

}
