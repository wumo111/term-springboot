package com.app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderid;

    /**
     * 预约日期
     */
    @TableField("orderDate")
    private LocalDate orderdate;

    /**
     * 客户编号
     */
    @TableField("userId")
    private String userid;

    /**
     * 所属医院编号
     */
    @TableField("hpId")
    private Integer hpid;

    /**
     * 所属套餐编号
     */
    @TableField("smId")
    private Integer smid;

    /**
     * 订单状态（1 未归档 2 已归档）
     */
    @TableField("state")
    private Integer state;


}
