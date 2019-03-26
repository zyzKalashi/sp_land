package com.kailash.land.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.RoleMenuEntity;
import com.kailash.land.mapper.RoleMenuMapper;
import com.kailash.land.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenuEntity> implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Override
    public List<RoleMenuEntity> selectByRoleId(Integer roldId) {
        return roleMenuMapper.selectByRoleId(roldId);
    }

    @Override
    public int delete(Integer menuId,Integer roleId) {
        return roleMenuMapper.deleteByMenuIdAndRoleId(menuId, roleId);
    }

    @Override
    public int add(RoleMenuEntity roleMenu) {
        return roleMenuMapper.insertSelective(roleMenu);
    }
}
