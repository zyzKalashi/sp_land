package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.DealPerson;
import com.kailash.land.filter.DealFiter;
import com.kailash.land.service.DealDetailService;
import com.kailash.land.service.DealInfoService;
import com.kailash.land.service.DealPersonService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "deal")
public class DealController {
	@Autowired
	private DealInfoService dealInfoService;

	@Autowired
	private DealDetailService dealDetailService;

	@Autowired
	private DealPersonService dealPersonService;

	@RequestMapping(value = "deal_add", method = RequestMethod.POST)
	public Result dealAdd(DealFiter filter) {
		DealPerson dp = filter.getDealPerson();
		this.dealPersonService.insterDealPerson(dp);
		return Result.ok();
	}

}
