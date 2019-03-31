package com.kailash.land.service;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.LoginLog;

public interface LoginLogService extends IService<LoginLog>{

	int insertOrUpdateByUserId(LoginLog ll);

}
