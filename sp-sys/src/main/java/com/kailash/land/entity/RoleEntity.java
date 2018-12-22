package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class RoleEntity implements Serializable {
	private Integer roleId;

	private String roleKey;

	private String roleName;


}