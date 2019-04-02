package com.kailash.land.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.NoticeInfo;
import com.kailash.land.entity.Users;

public interface NoticeInfoService {
	
	List<Map<String, Object>> queryIndexList();

	int instertNoticeInfo(NoticeInfo noticeInfo);
	
	PageInfo<NoticeInfo> selectNoticePage(NoticeInfo notice);

}
