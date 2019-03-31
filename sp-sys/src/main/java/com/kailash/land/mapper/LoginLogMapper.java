package com.kailash.land.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.LoginLog;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
	int insertOrUpdateByUserId(LoginLog ll);

	@Select("select * from login_log where user_id=#{userId}")
	LoginLog selectByUserId(@Param("userId") Long userId);

	@Update("UPDATE login_log set log_date = #{logDate} WHERE user_id=#{userId}")
	int updateByUserId(@Param("userId") Long userId, @Param("logDate") Date logDate);

	@Insert("INSERT login_log(user_id, log_date) VALUES (#{userId}, #{logDate})")
	int insertByUserId(@Param("userId") Long userId, @Param("logDate") Date logDate);

}
