package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.mapper.NoticeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.entity.NoticeInfo;
import com.kailash.land.service.NoticeInfoService;

@Service
public class NoticeInfoServiceImpl implements NoticeInfoService {
	@Autowired
	private NoticeInfoMapper noticeInfoMapper;

	@Override
	public List<Map<String, Object>> queryIndexList() {
		return this.noticeInfoMapper.queryIndexList();
	}

	@Override
	public int instertNoticeInfo(NoticeInfo noticeInfo) {
		return this.noticeInfoMapper.insert(noticeInfo);
	}
    
    public PageInfo<NoticeInfo> selectNoticePage(NoticeInfo notice){
		PageHelper.startPage(notice.getPageNo(), notice.getPageSize());
        List<NoticeInfo> users = this.noticeInfoMapper.selectNoticeInfo(notice);
        return new PageInfo<>(users);
    }
}
