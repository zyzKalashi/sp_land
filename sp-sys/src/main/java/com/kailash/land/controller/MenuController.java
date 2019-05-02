package com.kailash.land.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.MenuEntity;
import com.kailash.land.entity.RoleEntity;
import com.kailash.land.service.MenuService;
import com.kailash.land.service.RoleMenuService;
import com.kailash.land.service.RoleService;
import com.kailash.land.util.Result;

@Controller
public class MenuController extends AbstractController {
	@Autowired
	private MenuService menuService;
	private RoleMenuService roleMenuService;

	public Result menuList() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> menuMap = new HashMap<>();
		// 一级列表
//		menuMap.put("type", 1);
//		List<MenuEntity> menuEntities = menuService.selectMenuListByUserId(menuMap);
//
//		List<RoleEntity> roles = roleService.selectAllRoles();
//
//		// 二级列表
//		menuMap.put("type", 2);
//		for (MenuEntity menuEntity : menuEntities) {
//			menuEntity.setRole(roles);
//			menuMap.put("parentId", menuEntity.getMenuId());
//			List<MenuEntity> second = menuService.selectSecondByParentId(menuMap);
//			second.forEach((v) -> {
//				v.setRole(roles);
//			});
//			menuEntity.setSeconds(second);
//		}
//		map.put("menus", menuEntities);
		return Result.ok(map);
	}
}
