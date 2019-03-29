package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class HelpInfo extends Model<HelpInfo> implements Serializable {
	
	@TableId(value = "pkid", type = IdType.AUTO)
	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;
	
	private String helpTitle;

	private String helpText;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}
