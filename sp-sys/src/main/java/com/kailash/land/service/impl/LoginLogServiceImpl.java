package com.kailash.land.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.mapper.LoginLogMapper;
import com.kailash.land.service.LoginLogService;


@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
