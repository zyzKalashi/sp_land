package com.kailash.land.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.filter.BasePageFilter;
import com.kailash.land.service.DashboardService;
import com.kailash.land.util.Result;

@Controller
@RequestMapping(value = "/charts")
public class ChartsController extends AbstractController {

	@Autowired
	private DashboardService dashboardService;

	/**
	 * 获取仪表盘数据
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/getDashBordData")
	public Result getDashBordData() {
		try {
			var user = getUser();
			return Result.ok(dashboardService.getDashboardData(user));
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("获取初始化数据失败");
		}
	}

	/**
	 * 获取仪表盘数据
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/getDashBordChart")
	public Result getDashBordChart(BasePageFilter filter) {
		try {
			return Result.ok(dashboardService.getDashBordChart(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("获取初始化数据失败");
		}
	}

	@ResponseBody
	@PostMapping(value = "/barData")
	public Result barData(BasePageFilter filter) {
		Map<String, Object> data = this.dashboardService.getChartsBarData(filter);
		return Result.ok(data);
	}
}
