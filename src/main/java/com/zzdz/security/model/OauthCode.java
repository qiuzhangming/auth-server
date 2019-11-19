package com.zzdz.security.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class OauthCode implements Serializable {

    private Date createTime;

    private String code;

    private byte[] authentication;
}