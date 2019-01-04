package com.kailash.land.dao;

import com.kailash.land.entity.DemandInfo;

public interface DemandInfoMapper {
    int deleteByPrimaryKey(Integer pkid);

    int insert(DemandInfo record);

    int insertSelective(DemandInfo record);

    DemandInfo selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(DemandInfo record);

    int updateByPrimaryKeyWithBLOBs(DemandInfo record);

    int updateByPrimaryKey(DemandInfo record);
}