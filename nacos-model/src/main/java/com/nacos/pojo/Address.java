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
@TableName("address")
public class Address {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    @TableField(value = "contact")
    private String contact;
    @TableField(value = "addressDesc")
    private String addressDesc;
    @TableField(value = "postCode")
    private String postCode;
    @TableField(value = "tel")
    private String tel;
    @TableField(value = "createdBy")
    private BigInteger createdBy;
    @TableField(value = "creationDate")
    private Date creationDate;
    @TableField(value = "modifyBy")
    private BigInteger modifyBy;
    @TableField(value = "modifyDate")
    private Date modifyDate;
    @TableField(value = "userId")
    private BigInteger userId;
}
