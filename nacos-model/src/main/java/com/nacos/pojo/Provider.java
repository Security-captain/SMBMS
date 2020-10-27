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
@TableName("provider")
public class Provider {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    @TableField(value = "proCode")
    private String proCode;
    @TableField(value = "proName")
    private String proName;
    @TableField(value = "proDesc")
    private String proDesc;
    @TableField(value = "proContact")
    private String proContact;
    @TableField(value = "proPhone")
    private String proPhone;
    @TableField(value = "proAddress")
    private String proAddress;
    @TableField(value = "proFax")
    private String proFax;
    @TableField(value = "createdBy")
    private BigInteger createdBy;
    @TableField(value = "creationDate")
    private Date creationDate;
    @TableField(value = "modifyDate")
    private Date modifyDate;
    @TableField(value = "modifyBy")
    private BigInteger modifyBy;
}
