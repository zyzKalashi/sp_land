package com.kailash.land.entity;

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

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("doc_info")
public class DocInfo extends Model<DocInfo> implements Serializable  {
    @TableId(value = "pkid", type = IdType.AUTO)
    private Integer docId;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档内容
     */
    @TableField("doc_text")
    private String docText;

    /**
     * 文档下载路径
     */
    @TableField("doc_url")
    private String docUrl;

    /**
     * 文档类别
     */
    @TableField("doc_type")
    private Integer docType;

    /**
     * 文档状态
     */
    @TableField("doc_status")
    private Integer docStatus;

    /**
     * 创建日期
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 更新日期
     */
    @TableField("update_date")
    private Date updateDate;

    /**
     * 更新人
     */
    @TableField("update_user")
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
        return docId;
    }
    
    public String getCreateDateStr() {
        return DateUtils.format(this.createDate, DateFormatConsts.DATE_PATTERN);
    }
}
