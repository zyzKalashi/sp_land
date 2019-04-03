package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.NoticeInfo;

@Mapper
public interface NoticeInfoMapper extends BaseMapper<NoticeInfo> {

	List<Map<String, Object>> queryIndexList();

	List<NoticeInfo> selectNoticeInfo(NoticeInfo notice);

	/**
	 * @author zyz
	 * @param notice
	 * @return
	 */
	Page<Map<String, Object>> querySimpleList(@Param("obj") NoticeInfo notice);
}
