package com.zzdz.security.service;

import com.zzdz.security.model.RelationalUserAuthority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname RelationalUserAuthorityMapperServiceImplTest
 * @Description TODO
 * @Date 2019/11/6 17:06
 * @Created by joe
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationalUserAuthorityMapperServiceImplTest {

    @Autowired
    RelationalUserAuthorityMapperService userAuthorityMapperService;

    @Test
    public void save() {
        RelationalUserAuthority userAuthority = new RelationalUserAuthority(null, 12, 1);
        RelationalUserAuthority save = userAuthorityMapperService.save(userAuthority);
        System.out.println(save);
    }

    @Test
    public void deleteById() {
        boolean b = userAuthorityMapperService.deleteById(2);
        System.out.println(b);
    }

    @Test
    public void updateById() {
        RelationalUserAuthority userAuthority = new RelationalUserAuthority(1, 12, 1);
        boolean b = userAuthorityMapperService.updateById(userAuthority);
        System.out.println(b);
    }

    @Test
    public void findByUserIdAndAuthorityId() {
        RelationalUserAuthority userAuthority = userAuthorityMapperService.findByUserIdAndAuthorityId(12, 1);
        System.out.println(userAuthority);
    }

    @Test
    public void findByUserId() {
        List<RelationalUserAuthority> userAuthorities = userAuthorityMapperService.findByUserId(12);
        System.out.println(userAuthorities);
    }
}