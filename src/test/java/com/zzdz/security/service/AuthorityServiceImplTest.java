package com.zzdz.security.service;

import com.zzdz.security.model.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Classname AuthorityServiceImplTest
 * @Description TODO
 * @Date 2019/11/6 16:32
 * @Created by joe
 */
//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityServiceImplTest {

    @Autowired
    AuthorityService authorityService;

    @Test
    public void save() {
        Authority authority = new Authority(null, "p1", "p1权限");
        Authority authority1 = authorityService.save(authority);
        System.out.println(authority1);
    }

    @Test
    public void deleteById() {
        boolean b = authorityService.deleteById(2);
        System.out.println(b);
    }

    @Test
    public void updateById() {
        Authority authority = new Authority(1, "p1", "p1权限.");
        boolean b = authorityService.updateById(authority);
        System.out.println(b);
    }

    @Test
    public void findById() {
        Authority authority = authorityService.findById(1);
        System.out.println(authority);
    }
}