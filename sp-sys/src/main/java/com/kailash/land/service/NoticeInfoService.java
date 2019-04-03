package com.kailash.land.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.NoticeInfo;

public interface NoticeInfoService extends IService<NoticeInfo> {

	PageInfo<NoticeInfo> selectNoticePage(NoticeInfo notice);

	/**
	 * 列表数据-分页-前台页面
	 * 
	 * @author zyz
	 * @param notice
	 * @return
	 */
	PageInfo<Map<String, Object>> simpleList(NoticeInfo notice);

}
