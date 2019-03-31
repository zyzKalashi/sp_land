package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("area_code")
@SuppressWarnings("serial")
public class AreaCode extends Model<AreaCode> {

	@TableId(value = "areaCode", type = IdType.AUTO)
	@TableField("area_code")
	private Long areaCode;

	@TableField("area_name")
	private String areaName;

	@TableField("level")
	private Integer level;

	@TableField("parent_code")
	private Long parentCode;

	@Override
	protected Serializable pkVal() {
		return areaCode;
	}

}
