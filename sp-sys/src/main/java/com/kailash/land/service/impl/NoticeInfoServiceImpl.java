package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.NoticeInfoMapper;
import com.kailash.land.service.NoticeInfoService;

@Service
public class NoticeInfoServiceImpl implements NoticeInfoService {
	@Autowired
	private  NoticeInfoMapper noticeInfoMapper;
	
	@Override
	public List<Map<String, Object>> queryIndexList() {
		return this.noticeInfoMapper.queryIndexList();
	}

}
