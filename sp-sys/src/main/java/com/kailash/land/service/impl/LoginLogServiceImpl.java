package com.kailash.land.service.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.mapper.LoginLogMapper;
import com.kailash.land.service.LoginLogService;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
	@Autowired
	private LoginLogMapper loginLogMapper;

	@Override
	public int insertOrUpdateByUserId(LoginLog loginLog) {

		LoginLog ll = this.loginLogMapper.selectByUserId(loginLog.getUserId());
		if (Objects.isNull(ll)) {
			return this.loginLogMapper.insertByUserId(loginLog.getUserId(), new Date());
		} else {
			return this.loginLogMapper.updateByUserId(loginLog.getUserId(), new Date());
		}
	}

}
