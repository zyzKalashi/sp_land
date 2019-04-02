package com.kailash.land.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.VisitLog;
import com.kailash.land.mapper.VisitLogMapper;
import com.kailash.land.service.VisitLogService;

@Service
public class VisitLogServiceImpl extends ServiceImpl<VisitLogMapper, VisitLog> implements VisitLogService {

	@Override
	public int insertOrUpdateByBizId(VisitLog visitLog) {
		int visitNum = 0;
		VisitLog oldVisitLog = this.baseMapper.selectOne(visitLog);
		if (Objects.isNull(oldVisitLog)) {
			visitLog.setVisitNum(1);
			this.baseMapper.insertAllColumn(visitLog);
			visitNum = visitLog.getVisitNum();
		} else {
			Wrapper<VisitLog> wrapper = new EntityWrapper<VisitLog>(
					new VisitLog(visitLog.getBizKind(), visitLog.getBizId()));
			oldVisitLog.setVisitNum(oldVisitLog.getVisitNum() + 1);
			this.baseMapper.update(oldVisitLog, wrapper);
			visitNum = oldVisitLog.getVisitNum();
		}
		return visitNum;
	}

}
