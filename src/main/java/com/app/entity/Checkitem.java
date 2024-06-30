package com.app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Byterain
 * @since 2024-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("checkitem")
public class Checkitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检查项编号
     */
    @TableId(value = "ciId", type = IdType.AUTO)
    private Integer ciid;

    /**
     * 检查项名称
     */
    @TableField("ciName")
    private String ciname;

    /**
     * 检查项内容
     */
    @TableField("ciContent")
    private String cicontent;

    /**
     * 检查项意义
     */
    @TableField("meaning")
    private String meaning;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;


}
