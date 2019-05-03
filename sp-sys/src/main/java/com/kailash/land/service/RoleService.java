package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.RoleEntity;

import java.util.List;

public interface RoleService extends IService<RoleEntity> {

	/**
	 * queryObject
	 * 
	 * @author zyz
	 * @param roleId
	 * @return
	 */
	RoleEntity queryObject(int roleId);

	int queryRoleId(String roleKey);

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	PageInfo<RoleEntity> selectList();
	
	/**
	 * 获取所角色信息
	 * @return
	 */
	List<RoleEntity> selectAllRoles();
	
	List<RoleEntity> queryMenuRole(Long menuId);
}
