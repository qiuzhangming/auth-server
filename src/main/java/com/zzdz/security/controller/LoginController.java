package com.zzdz.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019/10/31 16:34
 * @Created by joe
 */
@RestController
public class LoginController {

    @PostMapping("/login-success")
    public String loginSuccess() {
        return "登陆成功。";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/r/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        return "hello";
    }
}
