package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class RoleEntity extends Model<RoleEntity> implements Serializable {
	private Integer roleId;

	private String roleKey;

	private String roleName;

	@Override
	protected Serializable pkVal() {
		return roleId;
	}

}