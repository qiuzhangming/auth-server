package com.zzdz.security.dao;

import com.zzdz.security.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Classname UserDaoImplTest
 * @Description TODO
 * @Date 2019/11/4 15:19
 * @Created by joe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("zs");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        user.setFullname("张三");
        user.setMobile("13333333333");
        user.setAccountNonExpired(false);
        user.setAccountNonLocked(false);
        user.setEnabled(true);
        user.setDeleted(false);

        System.out.println(userDao.save(user));
    }

    @Test
    public void deleteById() {
        System.out.println(userDao.deleteById(7));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(6);
        user.setFullname("张三666");

        System.out.println(userDao.updateUser(user));
    }

    @Test
    public void findByUsername() {
        User user = userDao.findByUsername("zs");
        System.out.println(user);
    }

}