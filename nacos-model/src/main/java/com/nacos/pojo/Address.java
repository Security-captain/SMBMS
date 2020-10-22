package com.nacos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private BigInteger id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private BigInteger createdBy;
    private Date creationDate;
    private BigInteger modifyBy;
    private Date modifyDate;
    private BigInteger userId;
}
