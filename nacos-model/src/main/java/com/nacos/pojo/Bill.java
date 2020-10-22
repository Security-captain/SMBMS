package com.nacos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {
    private BigInteger id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private BigDecimal productCount;
    private BigDecimal totalPrice;
    private BigInteger isPayment;
    private BigInteger createdBy;
    private Date creationDate;
    private BigInteger modifyBy;
    private Date modifyDate;
    private BigInteger providerId;
}
