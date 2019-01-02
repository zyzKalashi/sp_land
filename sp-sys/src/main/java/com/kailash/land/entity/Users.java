package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Users extends BaseEntity implements Serializable {

	private String userName;
	private String nickName;
	private String password;
	/*
	 * 用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	 */
	private Integer userStatus;
	private Integer roleId;
	private String mobile;
	private String tel;
	private String email;
	private Integer sex;
	private String birthday;
	private Integer marryFlag;
	private String address;
	private String postcode;
	private String company;
	private String position;
	private String idCardPic;
	private String idCardPicBack;
	private String userPic;
}