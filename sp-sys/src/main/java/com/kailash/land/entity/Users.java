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
@TableName("users")
@SuppressWarnings("serial")
public class Users extends Model<Users> implements Serializable {
	@TableId(value = "pkid", type = IdType.AUTO)
	private Long userId;
	private Date createDate;
	private Integer createUser;
	private String updateDate;
	private Integer updateUser;
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
	private Integer marryFlag;
	private String birthday;
	private String address;
	private String company;
	private String position;
	private String idCardPic;
	private String idCardPicBack;
	private String userPic;
	private String postcode;

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}
}