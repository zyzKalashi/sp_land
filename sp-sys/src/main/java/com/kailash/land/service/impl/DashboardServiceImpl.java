package com.kailash.land.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.filter.BasePageFilter;
import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.service.DashboardService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private ProjectMapper projectMapper;

	static Map<String, String> projectTypes = new HashMap<>();
	static {
		projectTypes.put("1", "土地承包");
		projectTypes.put("2", "林权转让");
		projectTypes.put("3", "养殖水面");
		projectTypes.put("4", "四荒承包");
	}

	@Override
	public Map<String, Object> getDashboardData() {
		Map<String, Object> result = new HashMap<>();

		String d1 = "0";
		String d2 = "0";
		String d3 = "0";
		String d4 = "0";

		// 统计项目信息
		Map<String, String> projectResult = projectMapper.projectStatistics();
		if (null != projectResult) {
			if (null != projectResult.get("ALL_PROJECT")) {
				d1 = projectResult.get("ALL_PROJECT");
			}
			if (null != projectResult.get("AUDIT_PROJECT")) {
				d2 = projectResult.get("AUDIT_PROJECT");
			}
		}
		// 统计会员信息
		Map<String, String> userResult = usersMapper.userStatistics();
		if (null != userResult) {
			if (null != userResult.get("ALL_USER")) {
				d3 = userResult.get("ALL_USER");
			}
			if (null != userResult.get("NEW_USER")) {
				d4 = userResult.get("NEW_USER");
			}
		}
		result.put("d1", d1);
		result.put("d2", d2);
		result.put("d3", d3);
		result.put("d4", d4);

		return result;
	}

	@Override
	public Map<String, Object> getDashBordChart(BasePageFilter filter) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> series = new ArrayList<>();
		Map<String, Object> seriesMap;
		List<String> dates = new ArrayList<String>();
		List<String> data;
		if (StringUtils.isEmpty(filter.getStartDate())) {
			filter.setStartDate(DateUtils.preDayYYMMDD(30));
		}
		if (StringUtils.isEmpty(filter.getEndDate())) {
			filter.setEndDate(DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN));
		}

		try {
			dates = DateUtils.everyDate(filter.getStartDate(), filter.getEndDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> projectDetail = projectMapper.projectDetailStatistics(filter);
		if (projectDetail != null && projectDetail.size() > 0) {
			for (int i = 1; i <= 4; i++) {
				seriesMap = new HashMap<>();
				data = new ArrayList<String>();
				for (Map<String, String> projectDetailMap : projectDetail) {
					if (projectDetailMap.get("KIND").equals(i + "")) {
						for (String date : dates) {
							data.add(projectDetailMap.get("TDATE").equals(date) ? projectDetailMap.get("TOTAL") : "0");
						}
					}
				}
				seriesMap.put("name", projectTypes.get(i + ""));
				seriesMap.put("type", "line");
				seriesMap.put("data", data);
				series.add(seriesMap);
			}
		}
		result.put("series", series);
		result.put("category", dates);
		return result;
	}

	@Override
	public Map<String, Object> getChartsBarData(BasePageFilter filter) {
		if (StringUtils.isEmpty(filter.getStartDate())) {
			filter.setStartDate(DateUtils.preDayYYMMDD(30));
		}
		if (StringUtils.isEmpty(filter.getEndDate())) {
			filter.setEndDate(DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN));
		}
		Map<String, Object> seriesMap = new HashMap<String, Object>();
		List<String> data = new ArrayList<String>();
		List<Map<String, Object>> datas = this.projectMapper.getChartsBarData(filter);
		String projectNum = "0";
		for (int i = 1; i <= projectTypes.size(); i++) {
			if (datas != null && datas.size() > 0) {
				for (Map<String, Object> map : datas) {
					if (map.get("projectKind").toString().equals(i + "")) {
						projectNum = map.get("projectNum").toString();
					}
				}
			}
			data.add(projectNum);
			projectNum = "0";
		}
		seriesMap.put("data", data);
		return seriesMap;
	}

}
