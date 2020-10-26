package com.nacos.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("bill")
public class Bill {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    @TableField(value = "userCode")
    private String billCode;
    @TableField(value = "productName")
    private String productName;
    @TableField(value = "productDesc")
    private String productDesc;
    @TableField(value = "productUnit")
    private String productUnit;
    @TableField(value = "productCount")
    private BigDecimal productCount;
    @TableField(value = "totalPrice")
    private BigDecimal totalPrice;
    @TableField(value = "isPayment")
    private BigInteger isPayment;
    @TableField(value = "createdBy")
    private BigInteger createdBy;
    @TableField(value = "creationDate")
    private Date creationDate;
    @TableField(value = "modifyBy")
    private BigInteger modifyBy;
    @TableField(value = "modifyDate")
    private Date modifyDate;
    @TableField(value = "providerId")
    private BigInteger providerId;
}
