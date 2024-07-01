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
 * @since 2024-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cireport")
public class Cireport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检查项报告主键
     */
    @TableId(value = "cir_Id", type = IdType.AUTO)
    private Integer cirId;

    /**
     * 检查项编号
     */
    @TableField("ci_Id")
    private Integer ciId;

    /**
     * 检查项名称
     */
    @TableField("ci_Name")
    private String ciName;

    /**
     * 所属预约编号
     */
    @TableField("order_Id")
    private Integer orderId;


}
