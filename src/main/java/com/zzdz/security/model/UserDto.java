package com.zzdz.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Classname UserDto
 * @Description TODO
 * @Date 2019/11/15 15:24
 * @Created by joe
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;
}
