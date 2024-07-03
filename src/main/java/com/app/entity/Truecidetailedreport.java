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
 * @since 2024-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("truecidetailedreport")
public class Truecidetailedreport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cidr_Id", type = IdType.AUTO)
    private Integer cidrId;

    @TableField("value")
    private Integer value;

    @TableField("si_Error")
    private Boolean siError;

    @TableField("cd_Id")
    private Integer cdId;

    @TableField("order_Id")
    private Integer orderId;


}
