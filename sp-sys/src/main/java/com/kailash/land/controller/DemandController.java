package com.kailash.land.controller;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.enums.StatusEnum;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.Demand;
import com.kailash.land.service.DemandService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "demand")
public class DemandController extends AbstractController {

	@Autowired
	private DemandService demandService;

	@RequestMapping(value = "demandModfiy", method = RequestMethod.POST)
	public Result demandModfiy(Demand demand) {
		try {
			if (Objects.isNull(demand.getDemandKind()) || Objects.isNull(demand.getTitle())
					|| Objects.isNull(demand.getDetail()) || Objects.isNull(demand.getPerson())
					|| Objects.isNull(demand.getMobile()) || Objects.isNull(demand.getEmail())) {
				return Result.error("填写信息不完整");
			}

			if (Objects.isNull(demand.getDemandId())) {
				demand.setCreateDate(new Date());
				demand.setCreateUser(getUserId().intValue());
			}
			demand.setUpdateDate(new Date());
			demand.setUpdateUser(getUserId().intValue());
			demand.setDemandStatus(StatusEnum.COMMON_NORMAL.getId());

			this.demandService.insertOrUpdate(demand);

		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

}
