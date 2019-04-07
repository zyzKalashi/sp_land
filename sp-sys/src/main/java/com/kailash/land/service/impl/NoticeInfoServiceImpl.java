package com.kailash.land.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.NoticeInfo;
import com.kailash.land.mapper.NoticeInfoMapper;
import com.kailash.land.service.NoticeInfoService;

@Service("noticeInfoService")
public class NoticeInfoServiceImpl extends ServiceImpl<NoticeInfoMapper, NoticeInfo> implements NoticeInfoService {

	@Autowired
	private NoticeInfoMapper noticeInfoMapper;

	@Override
	public PageInfo<NoticeInfo> selectNoticePage(NoticeInfo notice) {
		PageHelper.startPage(notice.getPageNo(), notice.getPageSize());
		List<NoticeInfo> users = this.noticeInfoMapper.selectNoticeInfo(notice);
		return new PageInfo<>(users);
	}

	/* zyz */
	@Override
	public PageInfo<Map<String, Object>> simpleList(NoticeInfo notice) {
		PageHelper.startPage(notice.getPageNo(), notice.getPageSize());
		Page<Map<String, Object>> pageList = this.noticeInfoMapper.querySimpleList(notice);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);
		return pageInfo;
	}

	@Override
	public PageInfo<Map<String, Object>> simpleImgList(NoticeInfo notice) {
		PageHelper.startPage(notice.getPageNo(), notice.getPageSize());
		Page<Map<String, Object>> pageList = this.noticeInfoMapper.querySimpleImgList(notice);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);
		return pageInfo;
	}
}
