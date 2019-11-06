package com.zzdz.security.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Classname MyUserDetailsServiceTest
 * @Description TODO
 * @Date 2019/11/6 17:28
 * @Created by joe
 */
//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserDetailsServiceTest {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Test
    public void loadUserByUsername() {

        UserDetails userDetails = myUserDetailsService.loadUserByUsername("zs");
        System.out.println(userDetails);

    }
}