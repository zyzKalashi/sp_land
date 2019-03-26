package com.kailash.land.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.RoleEntity;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

	/**
	 * findObject
	 *
	 * @param roleId
	 * @return
	 * @author zyz
	 */
	RoleEntity findObject(int roleId);

	List<RoleEntity> selectList();
}