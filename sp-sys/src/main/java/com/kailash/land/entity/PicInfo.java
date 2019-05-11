package com.kailash.land.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
 * <p>
 * 图片信息
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pic_info")
public class PicInfo extends Model<PicInfo> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "pkid", type = IdType.AUTO)
	private Integer picId;

	/* 图片标题 */
	private String title;

	/* 图片类别 */
	@TableField(value = "pic_type", strategy = FieldStrategy.NOT_EMPTY)
	private Integer picType;

	/*
	 * 图片状态
	 */
	@TableField(value = "pic_status", strategy = FieldStrategy.NOT_EMPTY)
	private Integer picStatus;

	/* 图片下载路径 */
	@TableField(value = "pic_url", strategy = FieldStrategy.NOT_EMPTY)
	private String picUrl;

	/* 图片链接 */
	@TableField(value = "pic_link", strategy = FieldStrategy.NOT_EMPTY)
	private String picLink;

	/* 图片序号 */
	@TableField(value = "pic_order", strategy = FieldStrategy.NOT_EMPTY)
	private Integer picOrder;

	/* 创建人 */
	@TableField(value = "create_user", strategy = FieldStrategy.NOT_EMPTY)
	private Integer createUser;

	/* 更新人 */
	@TableField(value = "update_user", strategy = FieldStrategy.NOT_EMPTY)
	private Integer updateUser;

	/* 创建日期 */
	@TableField(value = "create_date", strategy = FieldStrategy.NOT_EMPTY, fill = FieldFill.INSERT)
	private Date createDate;
	/* 更新日期 */
	@TableField(value = "update_date", strategy = FieldStrategy.NOT_EMPTY, fill = FieldFill.UPDATE, update = "NOW()")
	private Date updateDate;

	@TableField(exist = false)
	private String createDateStr;
	@TableField(exist = false)
	private Integer pageNo;
	@TableField(exist = false)
	private Integer pageSize;

	@Override
	protected Serializable pkVal() {
		return this.picId;
	}

}
