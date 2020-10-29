package com.nacos.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    @TableField(value = "userCode")
    private String userCode;
    @TableField(value = "userName")
    private String userName;
    @TableField(value = "userPassword")
    private String userPassword;
    @TableField(value = "gender")
    private Integer gender;
    @TableField(value = "birthday")
    private String birthday;
    @TableField(value = "phone")
    private String phone;
    @TableField(value = "address")
    private String address;
    @TableField(value = "userRole")
    private BigInteger userRole;
    @TableField(value = "createdBy")
    private BigInteger createdBy;
    @TableField(value = "creationDate")
    private String creationDate;
    @TableField(value = "modifyBy")
    private BigInteger modifyBy;
    @TableField(value = "modifyDate")
    private String modifyDate;
}
