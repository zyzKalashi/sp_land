package com.kailash.land.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @TableField("pic_url")
    private String picUrl;

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

    @Override
    protected Serializable pkVal() {
        return this.picId;
    }

}
