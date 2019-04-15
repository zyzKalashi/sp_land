package com.kailash.land.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.PicInfo;
import com.kailash.land.mapper.PicInfoMapper;
import com.kailash.land.service.PicInfoService;

/**
 * <p>
 * 图片信息 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
@Service
public class PicInfoServiceImpl extends ServiceImpl<PicInfoMapper, PicInfo> implements PicInfoService {
	@Autowired
	private PicInfoMapper picInfoMapper;

	@Override
	public PageInfo<Map<String, Object>> simpleList(PicInfo picInfo) {
		PageHelper.startPage(picInfo.getPageNo(), picInfo.getPageSize());
		Page<Map<String, Object>> pageList = this.picInfoMapper.querySimpleList(picInfo);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);
		return pageInfo;
	}

}
