package com.nacos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private BigInteger id;
    private String roleCode;
    private String roleName;
    private BigInteger createdBy;
    private Date creationDate;
    private BigInteger modifyBy;
    private Date modifyDate;
}
