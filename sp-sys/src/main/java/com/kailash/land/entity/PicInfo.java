package com.kailash.land.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 图片信息
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
@TableName("pic_info")
public class PicInfo extends Model<PicInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pkid", type = IdType.AUTO)
    private Integer picId;

    /**
     * 图片标题
     */
    private String title;

    /**
     * 图片类别
     */
    @TableField("pic_type")
    private Integer picType;

    /**
     * 图片状态
     */
    @TableField("pic_status")
    private Integer picStatus;

    /**
     * 图片下载路径
     */
    @TableField("doc_url")
    private String docUrl;

    /**
     * 图片链接
     */
    @TableField("pic_link")
    private String picLink;
    
    /**
     * 图片序号
     */
    @TableField("pic_order")
    private Integer picOrder;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 创建日期
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 更新人
     */
    @TableField("update_user")
    private Integer updateUser;

    /**
     * 更新日期
     */
    @TableField("update_date")
    private Date updateDate;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }
    public Integer getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(Integer picStatus) {
        this.picStatus = picStatus;
    }
    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }
    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }
    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.picId;
    }

}
