package com.kailash.land.service;

import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.RoleEntity;

public interface RoleService {
	
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
	 * @return
	 */
    PageInfo<RoleEntity> selectList();
}
