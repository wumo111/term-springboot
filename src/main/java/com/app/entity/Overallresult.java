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
@TableName("overallresult")
public class Overallresult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总检结论项编号
     */
    @TableId(value = "or_Id", type = IdType.AUTO)
    private Integer orId;

    /**
     * 总检结论项标题
     */
    @TableField("title")
    private String title;

    /**
     * 总检结论项内容
     */
    @TableField("content")
    private String content;

    /**
     * 所属预约编号
     */
    @TableField("order_Id")
    private Integer orderId;


}
