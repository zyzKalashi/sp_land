package com.kailash.land.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kailash.land.entity.DemandKind;

@Mapper
public interface DemandKindMapper extends BaseMapper<DemandKind> {
	int deleteByPrimaryKey(Integer pkid);

	int insertSelective(DemandKind record);

	DemandKind selectByPrimaryKey(Integer pkid);

	int updateByPrimaryKeySelective(DemandKind record);
	
	int instertBatch(@Param("demandInfoId")Integer demandInfoId, @Param("demandKindList")List<Integer> demandKindList);

}