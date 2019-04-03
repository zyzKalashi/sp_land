package com.kailash.land.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.AreaCode;
import com.kailash.land.mapper.AreaCodeMapper;
import com.kailash.land.service.AreaCodeService;

@Service
public class AreaCodeServiceImpl extends ServiceImpl<AreaCodeMapper, AreaCode> implements AreaCodeService {

	@Override
	public List<AreaCode> initArea() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("level", 1);

		List<AreaCode> level1 = this.baseMapper.selectByMap(param);
		for (AreaCode areaCode : level1) {
			param = new HashMap<String, Object>();
			param.put("parent_code", areaCode.getCode());
			param.put("level", 2);
			areaCode.setChildAreas(this.baseMapper.selectByMap(param));
		}
		return level1;
	}

}
