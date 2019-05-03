package com.kailash.land.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.MenuEntity;
import com.kailash.land.entity.RoleMenuEntity;
import com.kailash.land.service.MenuService;
import com.kailash.land.service.RoleMenuService;
import com.kailash.land.service.RoleService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping("menu")
public class MenuController extends AbstractController {
	@Autowired
	private MenuService menuService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleMenuService roleMenuService;

	@PostMapping("/menuList")
	public Result menuList() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> menuMap = new HashMap<>();
		// 一级列表
		menuMap.put("userId", getUserId());
		menuMap.put("type", 1);
		List<MenuEntity> menuEntities = menuService.selectMenuListByUserId(menuMap);
		// 二级列表
		menuMap.put("type", 2);
		for (MenuEntity menuEntity : menuEntities) {
			menuEntity.setRole(roleService.queryMenuRole(menuEntity.getMenuId()));
			menuMap.put("parentId", menuEntity.getMenuId());
			List<MenuEntity> second = menuService.selectSecondByParentId(menuMap);
			second.forEach((v) -> {
				v.setRole(roleService.queryMenuRole(v.getMenuId()));
			});
			menuEntity.setSeconds(second);
		}
		map.put("menus", menuEntities);
		return Result.ok(map);
	}

	@PostMapping("/insertRoleMenu")
	public Result insertRoleMenu(RoleMenuEntity entity) {
		this.roleMenuService.insert(entity);
		return Result.ok();
	}
	@PostMapping("/deleteRoleMenu")
	public Result deleteRoleMenu(RoleMenuEntity roleMenu) {
		this.roleMenuService.deleteById(roleMenu.getPkid());
		return Result.ok();
	}
}
