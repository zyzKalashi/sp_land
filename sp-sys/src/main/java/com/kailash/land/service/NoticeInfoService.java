package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.kailash.land.entity.NoticeInfo;

public interface NoticeInfoService {
	
	List<Map<String, Object>> queryIndexList();

	int instertNoticeInfo(NoticeInfo noticeInfo);

}
