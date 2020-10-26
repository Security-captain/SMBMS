package com.nacos.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("role")
public class Role {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    @TableField(value = "roleCode")
    private String roleCode;
    @TableField(value = "roleName")
    private String roleName;
    @TableField(value = "createdBy")
    private BigInteger createdBy;
    @TableField(value = "creationDate")
    private Date creationDate;
    @TableField(value = "modifyBy")
    private BigInteger modifyBy;
    @TableField(value = "modifyDate")
    private Date modifyDate;
}
