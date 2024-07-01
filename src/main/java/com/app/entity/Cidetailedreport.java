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
@TableName("cidetailedreport")
public class Cidetailedreport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检查项明细报告编号
     */
    @TableId(value = "cidr_Id", type = IdType.AUTO)
    private Integer cidrId;

    /**
     * 检查项明细名称
     */
    @TableField("name")
    private String name;

    /**
     * 检查项明细单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 检查项明细正常值范围中的最小值
     */
    @TableField("minrange")
    private Double minrange;

    /**
     * 检查项明细正常值范围中的最大值
     */
    @TableField("maxrange")
    private Double maxrange;

    /**
     * 检查项明细正常值（非数值型）
     */
    @TableField("normal_Value")
    private String normalValue;

    /**
     * 检查项验证范围说明文字
     */
    @TableField("normal_Value_String")
    private String normalValueString;

    /**
     * 检查项明细类型（1数值范围验证型 2数值相等验证型 3无需验证型 4描述型 5其它）
     */
    @TableField("type")
    private Integer type;

    /**
     * 检查项目明细值
     */
    @TableField("value")
    private String value;

    /**
     * 此项是否异常（0无异常 1异常）
     */
    @TableField("si_Error")
    private Integer siError;

    /**
     * 所属检查项报告编号
     */
    @TableField("ci_Id")
    private Integer ciId;

    /**
     * 所属预约编号
     */
    @TableField("order_Id")
    private Integer orderId;


}
