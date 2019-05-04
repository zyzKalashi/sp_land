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
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@TableName("project_audit")
public class ProjectAudit extends Model<ProjectAudit> implements Serializable {

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long projectAuditId;

	@TableField(value = "project_id", strategy = FieldStrategy.NOT_NULL)
	private Long projectId;
	@TableField(value = "project_status", strategy = FieldStrategy.NOT_NULL)
	private Integer projectStatus;
	@TableField(value = "role_id", strategy = FieldStrategy.NOT_NULL)
	private Integer roleId;
	@TableField(value = "audit_user", strategy = FieldStrategy.NOT_NULL)
	private Integer auditUser;
	@TableField(value = "audit_date", strategy = FieldStrategy.NOT_NULL)
	private Date auditDate;

	@Override
	protected Serializable pkVal() {
		return projectAuditId;
	}

}
