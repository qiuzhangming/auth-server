package com.zzdz.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
        return "hello,现在时间是：" + new Date();
    }


    @GetMapping("/r/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        return "访问r1资源。";
    }

    @GetMapping("/r/r2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String r2() {
        return "访问r2资源。";
    }
}
