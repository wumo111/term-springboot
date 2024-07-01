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
@TableName("doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医生编号
     */
    @TableId(value = "doc_Id", type = IdType.AUTO)
    private Integer docId;

    /**
     * 医生编码（登录使用）
     */
    @TableField("doc_Code")
    private String docCode;

    /**
     * 真实姓名
     */
    @TableField("real_Name")
    private String realName;

    /**
     * 密码（登录使用）
     */
    @TableField("password")
    private String password;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 所属科室（1 检验科 2内科 3外科）
     */
    @TableField("deptno")
    private Integer deptno;


}
