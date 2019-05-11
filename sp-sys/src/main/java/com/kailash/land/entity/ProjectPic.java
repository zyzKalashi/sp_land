package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("project_pic")
public class ProjectPic extends Model<PicInfo> {
	private static final long serialVersionUID = 1L;

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long proPicId;
	
	@TableField(value = "project_id", strategy = FieldStrategy.NOT_EMPTY)
	private Integer projectId;
	@TableField(value = "pic_kind", strategy = FieldStrategy.NOT_EMPTY)
	private Integer picKind;// 1-身份证，2-产权证，3合同书
	@TableField(value = "pic_url", strategy = FieldStrategy.NOT_EMPTY)
	private String picUrl;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Date createDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer createUser;

	@Override
	protected Serializable pkVal() {
		return proPicId;
	}

}
