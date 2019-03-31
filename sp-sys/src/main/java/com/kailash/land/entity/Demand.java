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
@SuppressWarnings("serial")
@TableName("demand")
public class Demand extends Model<Demand> implements Serializable {
	@TableId(value="pkid", type=IdType.AUTO)
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

	@Override
	protected Serializable pkVal() {
		return demandId;
	}

}