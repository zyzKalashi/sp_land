package com.kailash.land.service;

import java.util.List;

import com.kailash.land.entity.RoleMenuEntity;

public interface RoleMenuService {
    List<RoleMenuEntity> selectByRoleId(Integer roldId);
    /**
     * 删除对象
     * @param menuId 菜单ID
     * @param roleId 角色ID
     * @return
     */
    int delete(Integer menuId, Integer roleId);

    /**
     * 添加对象
     * @param roleEnum
     * @return
     */
    int add(RoleMenuEntity roleEnum);
}
