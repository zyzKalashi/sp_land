package com.kailash.land.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.AreaCode;
import com.kailash.land.mapper.AreaCodeMapper;
import com.kailash.land.service.AreaCodeService;

@Service
public class AreaCodeServiceImpl extends ServiceImpl<AreaCodeMapper, AreaCode> implements AreaCodeService {
	@Autowired
	private AreaCodeMapper areaCodeMapper;

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

	@Override
	public List<Map<String, Object>> areaTree() {
		List<Map<String, Object>> parent = this.areaCodeMapper.areaTree(0);
		if (parent != null && parent.size() > 0) {
			parent.forEach(v -> {
				if (v.get("id").toString().equals("1")) {
					v.put("open", true);
				}
				v.put("children", this.areaCodeMapper.areaTree(Integer.parseInt(v.get("id").toString())));
			});
		}
		var root = new ArrayList<Map<String, Object>>();
		var rootNode = new HashMap<String, Object>();
		rootNode.put("id", 0);
		rootNode.put("areaId", 0);
		rootNode.put("level", 0);
		rootNode.put("name", "四平市");
		rootNode.put("parentId", 0);
		rootNode.put("children", parent);
		rootNode.put("open", true);
		root.add(rootNode);
		return root;
	}

}
