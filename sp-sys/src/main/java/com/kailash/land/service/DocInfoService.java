package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.DocInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2019-04-05
 */
public interface DocInfoService extends IService<DocInfo> {
    PageInfo<DocInfo> selectNoticePage(DocInfo doc);
}
