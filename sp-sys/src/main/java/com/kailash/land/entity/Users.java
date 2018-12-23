package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Users implements Serializable {

	private Integer userId;

	private String userName;
	/**
	 * 公司名称
	 */
	private String nickName;

	private String password;
	/**
	 * 用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	 */
	private Integer userStatus;

	private Integer roleId;

	private String createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	private String mobile;

	private String email;

}