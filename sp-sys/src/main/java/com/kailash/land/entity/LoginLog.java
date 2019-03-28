package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("login_log")
public class LoginLog extends Model<LoginLog> {
	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;

	private Long userId;
	private Date logDate;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

	public LoginLog(Long userId) {
		this.userId = userId;
		logDate = new Date();
	}

}
