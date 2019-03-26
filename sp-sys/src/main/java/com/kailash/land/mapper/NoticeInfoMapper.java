package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.NoticeInfo;

@Mapper
public interface NoticeInfoMapper extends BaseMapper<NoticeInfo> {

	List<Map<String, Object>> queryIndexList();

}
