package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TagInfo extends Model<TagInfo> {
	
	private static final long serialVersionUID = 1L;

	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	private String tagName;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}
