package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.NewsInfoMapper;
import com.kailash.land.entity.NewsInfo;
import com.kailash.land.service.NewsInfoService;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
	
	@Autowired
	private NewsInfoMapper newsInfoMapper;
	
	
	@Override
	public NewsInfo instertNewsInfo(NewsInfo ni) {
		return this.newsInfoMapper.instertEntity(ni);
	}
	
	

}
