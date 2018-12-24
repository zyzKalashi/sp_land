package com.kailash.land.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class DealController {
	
	@Autowired
	private DealInfoService dealInfoService;

	@Autowired
	private DealAroundService dealAroundService;

	@Autowired
	private DealPersonService dealPersonService;

	@RequestMapping(value = "deal_add", method = RequestMethod.POST)
	public Result dealAdd(DealFiter filter) {
		try {
			DealPerson dp = this.dealPersonService.instertDealPerson(filter.getDealPerson());

			DealInfo di = this.dealInfoService.instertDealInfo(filter.getDealInfo());

			dp.setDealInfoId(di.getPkid());
			this.dealPersonService.updateDealPerson(dp);

			List<DealAround> dealAroundList = filter.getDealAroundList();
			if (dealAroundList != null && dealAroundList.size() > 0) {
				for (DealAround dealAround : dealAroundList) {
					dealAround.setDealInfoId(di.getPkid());
					this.dealAroundService.instertDealAround(dealAround);
				}
			}
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}

}
