package com.nacos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private BigInteger id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer gender;
    private Date birthday;
    private String phone;
    private String address;
    private BigInteger userRole;
    private BigInteger createdBy;
    private Date creationDate;
    private BigInteger modifyBy;
    private Date modifyDate;
}
