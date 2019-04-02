package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.VisitLog;

public interface VisitLogService extends IService<VisitLog> {

	int insertOrUpdateByBizId(VisitLog visitLog);

}
