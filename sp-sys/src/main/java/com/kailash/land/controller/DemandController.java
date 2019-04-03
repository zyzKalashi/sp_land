package com.kailash.land.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
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

	@ResponseBody
	@PostMapping(value = "/simpleList")
	public Result simpleList(Demand demand) {

		PageInfo<Map<String, Object>> pageInfo = this.demandService.simpleList(demand);

		return Result.ok().put("pageInfo", pageInfo);
	}

	@ResponseBody
	@PostMapping(value = "/demandDetail")
	public Result demandDetail(Demand demand) {
		if (Objects.isNull(demand.getDemandId())) {
			return Result.error("参数错误");
		}
		demand = this.demandService.selectById(demand.getDemandId());
		return Result.ok().put("objData", demand);
	}

	@ResponseBody
	@PostMapping(value = "/queryPreNext")
	public Result queryPreNext(Demand demand) {
		demand.setPageNo(1);
		demand.setPageSize(999999);

		PageInfo<Map<String, Object>> pageInfo = this.demandService.simpleList(demand);
		int index = 0;
		Demand preDemand = null, nextDemand = null;

		List<Map<String, Object>> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (demand.getDemandId().equals(Long.parseLong(list.get(i).get("demandId").toString()))) {
					index = i;
					break;
				}
			}
		}
		if (index > 0) {
			preDemand = this.demandService.selectById((Serializable) list.get(index - 1).get("demandId"));
		}
		if (index < list.size() - 1) {
			nextDemand = this.demandService.selectById((Serializable) list.get(index + 1).get("demandId"));
		}

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("preDemand", preDemand);
		returnMap.put("nextDemand", nextDemand);

		return Result.ok(returnMap);
	}
	
	
}
