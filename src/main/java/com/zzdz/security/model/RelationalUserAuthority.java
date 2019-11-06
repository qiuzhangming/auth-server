package com.zzdz.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname RelationalUserAuthority
 * @Description 用户和权限关系
 * @Date 2019/11/6 16:43
 * @Created by joe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationalUserAuthority {

    private Integer id;

    private Integer userId;

    private Integer authorityId;
}
