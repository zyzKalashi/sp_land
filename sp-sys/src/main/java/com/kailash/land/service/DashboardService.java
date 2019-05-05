package com.kailash.land.service;

import java.util.Map;

import com.kailash.land.entity.Users;
import com.kailash.land.filter.BasePageFilter;

public interface DashboardService {
	
	Map<String, Object> getDashboardData(Users user);

	Map<String, Object> getDashBordChart(BasePageFilter filter);

	Map<String, Object> getChartsBarData(BasePageFilter filter);
}
