package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

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
@TableName("notice_info")
@SuppressWarnings("serial")
public class NoticeInfo extends Model<NoticeInfo> implements Serializable {
	private Integer noticeStatus;

	private String title;

	private String companyName;

	private Integer noticeKind;

	private String noticeText;

	private String noticePic;

	@TableId(value = "pkid", type = IdType.AUTO)
	private Integer noticeId;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	@TableField(exist = false)
	private String createDateStr;
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
		return noticeId;
	}

	public String getCreateDateStr() {
		return DateUtils.format(this.createDate, DateFormatConsts.DATE_PATTERN);
	}
}
