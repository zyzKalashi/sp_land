package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@TableName("demand")
public class Demand extends Model<Demand> implements Serializable {
	@TableId(value = "pkid", type = IdType.AUTO)
	private Long demandId;

	private Date createDate;
	private Integer createUser;
	private Date updateDate;
	private Integer updateUser;

	private Integer demandKind;
	private Integer moneyLevel;
	private Integer demandInfoKind;
	private String title;
	private String detail;
	private String person;
	private String mobile;
	private String email;
	private String fileUrl;

	private Integer demandStatus;
	private Integer sex;

	@TableField(exist = false)
	private String createDateStr;
	@TableField(exist = false)
	private String queryPage;
	@TableField(exist = false)
	private Integer pageNo;
	@TableField(exist = false)
	private Integer pageSize;
	@TableField(exist = false)
	private String startDate;
	@TableField(exist = false)
	private String endDate;

	@Override
	protected Serializable pkVal() {
		return demandId;
	}

	public String getCreateDateStr() {
		if (StringUtils.isEmpty(createDateStr)) {
			return DateUtils.format(this.createDate, DateFormatConsts.DATE_PATTERN);
		}
		return this.createDateStr;
	}

	public Demand(Long demandId, Integer demandStatus) {
		this.demandId = demandId;
		this.demandStatus = demandStatus;
	}

}