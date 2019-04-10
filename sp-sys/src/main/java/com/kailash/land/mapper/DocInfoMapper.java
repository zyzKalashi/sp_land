package com.kailash.land.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.DocInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2019-04-05
 */
public interface DocInfoMapper extends BaseMapper<DocInfo> {
    List<DocInfo> selectDocInfo(DocInfo docInfo);

}
