package com.kailash.land.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.PicInfo;

/**
 * <p>
 * 图片信息 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
public interface PicInfoMapper extends BaseMapper<PicInfo> {

	Page<Map<String, Object>> querySimpleList(PicInfo picInfo);

}
