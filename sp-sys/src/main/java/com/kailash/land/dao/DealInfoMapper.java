package com.kailash.land.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kailash.land.entity.DealInfo;

@Mapper
public interface DealInfoMapper extends BaseMapper<DealInfo>{
    int deleteByPrimaryKey(Integer pkid);

    DealInfo selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(DealInfo record);

	List<Map<String, Object>> queryIndexNewList();

	List<Map<String, Object>> queryIndexKindList();

}