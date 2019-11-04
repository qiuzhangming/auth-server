package com.zzdz.security.model;

import lombok.Data;


/**
 * @Classname User
 * @Description TODO
 * @Date 2019/11/4 13:30
 * @Created by joe
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    // 帐户是否过期
    private Boolean accountNonExpired;

    // 账户是否锁定
    private Boolean accountNonLocked;

    // 是否启用
    private Boolean enabled;

    // 是否删除
    private Boolean deleted;

}
