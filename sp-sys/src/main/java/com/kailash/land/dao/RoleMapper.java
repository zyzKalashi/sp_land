package com.kailash.land.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kailash.land.entity.RoleEntity;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleEntity entity);

    int insertSelective(RoleEntity entity);

    RoleEntity selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

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