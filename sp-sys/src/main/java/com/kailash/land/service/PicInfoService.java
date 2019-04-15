package com.kailash.land.service;

import com.kailash.land.entity.PicInfo;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 图片信息 服务类
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
public interface PicInfoService extends IService<PicInfo> {

	PageInfo<Map<String, Object>> simpleList(PicInfo picInfo);

}
