package com.zzdz.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @Classname User
 * @Description TODO
 * @Date 2019/11/4 13:30
 * @Created by joe
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;

    // 是否启用
    private Boolean enabled;

    // 是否删除
    private Boolean deleted;

    List<Authority> authorities = new ArrayList<>();
}
