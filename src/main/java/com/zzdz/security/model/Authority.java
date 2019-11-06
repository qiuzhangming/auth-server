package com.zzdz.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Authority
 * @Description 用户资源
 * @Date 2019/11/6 12:05
 * @Created by joe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    private Integer id;

    private String authorityName;

    private String authorityDescribe;
}
