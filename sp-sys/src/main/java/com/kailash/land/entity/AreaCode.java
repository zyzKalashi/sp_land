package com.kailash.land.entity;

import java.io.Serializable;
import java.util.List;

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

	@TableId(value = "code", type = IdType.AUTO)
	private Long code;

	@TableField("area_name")
	private String areaName;

	@TableField("level")
	private Integer level;

	@TableField("parent_code")
	private Long parentCode;
	
	@TableField(exist = false)
	private List<AreaCode> childAreas;

	@Override
	protected Serializable pkVal() {
		return code;
	}

}
