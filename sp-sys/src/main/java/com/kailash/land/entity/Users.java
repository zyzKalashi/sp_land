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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("users")
public class Users extends Model<Users> {

	private static final long serialVersionUID = 1L;
	
	@TableId(value = "pkid", type = IdType.AUTO)
	private Long userId;
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer createUser;

	@TableField(value = "audit_date", strategy = FieldStrategy.NOT_NULL)
	private Date auditDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer auditUser;
	@TableField(value = "update_date", fill = FieldFill.UPDATE, update = "NOW()")
	private Date updateDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer updateUser;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String userName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String nickName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String password;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer roleId;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String mobile;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String tel;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String email;
	/*
	 * 用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	 */
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer userStatus;

	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer sex;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer marryFlag;
	// private String birthday;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String address;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String company;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String idCardNo;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String idCardPic;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String idCardPicBack;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String userPic;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String postcode;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer townCode;
	@TableField(strategy = FieldStrategy.NOT_NULL)
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