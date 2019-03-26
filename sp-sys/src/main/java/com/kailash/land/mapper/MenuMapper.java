package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.MenuEntity;

public interface MenuMapper extends BaseMapper<MenuEntity> {
	/**
	 * 根据menuId查询对象
	 *
	 * @param menuId
	 * @return
	 */
	MenuEntity selectEntityById(Integer menuId);

	List<MenuEntity> list();

	List<MenuEntity> selectMenuListByUserId(Map<String, Object> param);

	List<MenuEntity> selectPermsByRoleId(Integer roleId);

	/**
	 * 根据parentId和type =2查询二级列表
	 *
	 * @param params
	 * @return
	 */
	List<MenuEntity> selectSecondByParentId(Map<String, Object> params);

	/**
	 * 根据type =1查询一级列表 根据type =3 查询三级列表
	 *
	 * @return
	 */
	List<MenuEntity> selectListByType(int type);

	/**
	 * 更新对象
	 *
	 * @param entity
	 * @return
	 */
	int update(MenuEntity entity);

	/**
	 * 添加对象
	 *
	 * @param entity
	 * @return
	 */
	int add(MenuEntity entity);

}
