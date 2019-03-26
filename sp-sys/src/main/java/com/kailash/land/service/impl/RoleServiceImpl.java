package com.kailash.land.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.RoleEntity;
import com.kailash.land.mapper.RoleMapper;
import com.kailash.land.service.RoleService;

/**
 * @Date: Create in 2018/4/24
 */
@Service

public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	/* zyz */
	@Override
	public RoleEntity queryObject(int roleId) {
		return this.roleMapper.findObject(roleId);
	}

	@Override
	public int queryRoleId(String roleKey) {
		return 0;
	}

	@Override
	public PageInfo<RoleEntity> selectList() {
		PageHelper.startPage(1, 10);
		List<RoleEntity> roles = roleMapper.selectList();
		return new PageInfo<>(roles);
	}

}
