package com.kailash.land.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.TagInfoMapper;
import com.kailash.land.entity.TagInfo;
import com.kailash.land.service.TagInfoService;

@Service
public class TagInfoServiceImpl implements TagInfoService{
	@Autowired
	private TagInfoMapper tagInfoMapper;

	@Override
	public TagInfo instertTagInfo(TagInfo tagInfo) {
		return this.tagInfoMapper.instertEntity(tagInfo);
	}

	@Override
	public int updateTagInfo(TagInfo tagInfo) {
		return this.tagInfoMapper.updateEntity(tagInfo);
	}
}
