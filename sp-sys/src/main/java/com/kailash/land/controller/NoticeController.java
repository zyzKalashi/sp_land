package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kailash.land.entity.NewsDetail;
import com.kailash.land.entity.NewsInfo;
import com.kailash.land.filter.NewsFiter;
import com.kailash.land.service.NewsDetailService;
import com.kailash.land.service.NewsInfoService;
import com.kailash.land.service.NoticeInfoService;
import com.kailash.land.util.Result;

public class NoticeController {
	@Autowired
	private NoticeInfoService noticeInfoService;
	
	@Autowired
	private NewsInfoService newsInfoService;
	
	@Autowired
	private NewsDetailService newsDetailService;
	
	@RequestMapping(value = "news_add", method = RequestMethod.POST)
	public Result newsAdd(NewsFiter filter) {
		try {
			NewsInfo ni = this.newsInfoService.instertNewsInfo(filter.getNewsInfo());
			NewsDetail nd = filter.getNewsDetail();
			nd.setNewsInfoId(ni.getPkid()); 
			this.newsDetailService.instertNewsDetail(nd);
		} catch (Exception e) {
			return Result.error();
		}
		return Result.ok();
	}
}
