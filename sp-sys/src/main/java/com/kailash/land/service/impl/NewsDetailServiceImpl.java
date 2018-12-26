package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.NewsDetailMapper;
import com.kailash.land.entity.NewsDetail;
import com.kailash.land.service.NewsDetailService;

@Service
public class NewsDetailServiceImpl implements NewsDetailService {
	
	@Autowired
	private NewsDetailMapper newsDetailMapper;
	
	
	@Override
	public NewsDetail instertNewsDetail(NewsDetail nd) {
		return this.newsDetailMapper.instertEntity(nd);
	}
	
	

}
