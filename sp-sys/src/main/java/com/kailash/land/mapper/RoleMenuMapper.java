package com.kailash.land.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.RoleMenuEntity;

@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity>{
    List<RoleMenuEntity> selectByRoleId(Integer roldId);
    int deleteByPrimaryKey(Integer pkid);

    /**
     * 根据MenuId和RoleId删除
     * @param menuId 菜单 ID
     * @param roleId 角色 ID
     * @return
     */
    int deleteByMenuIdAndRoleId(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

    /**
     * 根据MenuId和RoleId查询
     * @param menuId 菜单 ID
     * @param roleId 角色 ID
     * @return
     */
    RoleMenuEntity selectByMenuIdAndRoleId(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

    int insertSelective(RoleMenuEntity record);

    RoleMenuEntity selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(RoleMenuEntity record);

}