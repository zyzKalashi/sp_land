package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

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
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer createUser;

	@TableField(value = "update_date", fill = FieldFill.UPDATE, update = "NOW()")
	private Date updateDate;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer updateUser;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String userName;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String nickName;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String password;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer roleId;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String mobile;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String tel;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String email;
	/*
	 * 用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	 */
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer userStatus;

	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer sex;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer marryFlag;
	// private String birthday;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String address;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String company;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String idCardNo;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String idCardPic;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String idCardPicBack;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String userPic;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private String postcode;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer townCode;
	@TableField(strategy = FieldStrategy.NOT_EMPTY)
	private Integer areaCode;

	@TableField(exist = false)
	private String createDateStr;
	@TableField(exist = false)
	private Integer pageNo;
	@TableField(exist = false)
	private Integer pageSize;

	@TableField(exist = false)
	private String fromPage;

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	public String getCreateDateStr() {
		return DateUtils.format(this.createDate, DateFormatConsts.DATE_TIME_PATTERN);
	}

}