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
@TableName("cireport")
public class Cireport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检查项报告主键
     */
    @TableId(value = "cirId", type = IdType.AUTO)
    private Integer cirid;

    /**
     * 检查项编号
     */
    @TableField("ciId")
    private Integer ciid;

    /**
     * 检查项名称
     */
    @TableField("ciName")
    private String ciname;

    /**
     * 所属预约编号
     */
    @TableField("orderId")
    private Integer orderid;


}
