package com.kailash.land.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.AreaCode;
import com.kailash.land.service.AreaCodeService;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "area")
public class AreaCodeController {

	@Autowired
	private AreaCodeService areaCodeService;
	@Autowired
	private ProjectService projectService;

	@ResponseBody
	@PostMapping(value = "/initArea")
	public Result initArea() {
		List<AreaCode> area = this.areaCodeService.initArea();
		return Result.ok().put("area", area);
	}

	@ResponseBody
	@PostMapping(value = "/areaTree")
	public List<Map<String, Object>> areaTree() {
		var areaTree = this.areaCodeService.areaTree();
		return areaTree;
	}

	/**
	 * 修改或添加对象
	 * 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/areaModify")
	public Result areaModify(AreaCode entity) {
		Integer areaId = entity.getAreaId();
		if (null != areaId) {
			this.areaCodeService.updateById(entity);
			return Result.ok("修改成功");
		} else {
			this.areaCodeService.insert(entity);
			return Result.ok("添加成功");
		}
	}

	/**
	 * 删除对象
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delete/{id}")
	public Result delete(@PathVariable("id") Long id) {
		boolean modify = this.areaCodeService.deleteById(id);
		return Result.ok().put("flag", modify);
	}

	/**
	 * 当前行业是否被绑定
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("checkUse/{id}")
	public Result checkUse(@PathVariable("id") Integer id) {
		if (id == null) {
			return Result.error("参数错误");
		}
		if (this.projectService.countByAreaCode(id) > 0) {
			return Result.error("地域被绑定，勿删");
		}
		// 有下级菜单的直接删除 TODO
		return Result.ok();
	}

}
