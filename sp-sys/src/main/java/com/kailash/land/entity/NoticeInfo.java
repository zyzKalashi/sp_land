package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class NoticeInfo extends Model<NoticeInfo> implements Serializable {
	private Integer noticeStatus;

	private String title;

	private String companyName;

	private Integer noticeKind;

	private String noticeText;

	private String createDateStr;

	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}
