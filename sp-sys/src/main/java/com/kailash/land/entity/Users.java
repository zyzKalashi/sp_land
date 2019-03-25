package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Users extends BaseEntity implements Serializable {

	private String userName;
	private String password;
	private Integer roleId;
	private String mobile;
	private String tel;
	private String email;
	/*
	 * 用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	 */
	private Integer userStatus;

	private Integer sex;
	private String birthday;
	private String address;
	private String company;
	private String position;
	private String idCardPic;
	private String idCardPicBack;
	private String userPic;
}