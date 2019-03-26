package com.kailash.land.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.DealAround;

/**
 * 
 * @author zyz
 *
 */
@Mapper
public interface DealAroundMapper extends BaseMapper<DealAround>{
    int deleteByPrimaryKey(Integer pkid);

    DealAround selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(DealAround record);

    int updateByPrimaryKey(DealAround record);
}