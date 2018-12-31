package com.kailash.land.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.DealInfoMapper;
import com.kailash.land.entity.DealInfo;
import com.kailash.land.service.DealInfoService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

@Service
public class DealInfoServiceImpl implements DealInfoService {

	@Autowired
	private DealInfoMapper dealInfoMapper;

	@Override
	public int instertDealInfo(DealInfo dealInfo) {
		dealInfo.setDealNum("TX-" + DateUtils.format(new Date(), DateFormatConsts.DAY_HOUR_MINUTES) + "-100100");
		return this.dealInfoMapper.instertEntity(dealInfo);
	}

	@Override
	public List<Map<String, Object>> queryIndexNewList() {
		return this.dealInfoMapper.queryIndexNewList();
	}

	@Override
	public List<Map<String, Object>> queryIndexKindList(Integer kind) {
		return this.dealInfoMapper.queryIndexKindList();
	}

}
