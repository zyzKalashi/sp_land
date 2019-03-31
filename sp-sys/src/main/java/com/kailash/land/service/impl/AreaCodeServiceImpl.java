package com.kailash.land.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kailash.land.entity.AreaCode;
import com.kailash.land.mapper.AreaCodeMapper;
import com.kailash.land.service.AreaCodeService;

@Service
public class AreaCodeServiceImpl extends ServiceImpl<AreaCodeMapper, AreaCode> implements AreaCodeService {

}
