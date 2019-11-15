package com.zzdz.security.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzdz.security.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname UserServiceImplTest
 * @Description TODO
 * @Date 2019/11/6 13:36
 * @Created by joe
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setFullname("管理员");
        user.setMobile("13333333333");
        user.setEnabled(true);
        user.setDeleted(false);
        System.out.println(userService.save(user));
    }

    @Test
    public void deleteById() {
        System.out.println(userService.deleteById(7));
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(12);
        user.setFullname("张三12");
        user.setMobile("10086");

        System.out.println(userService.updateById(user));
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("zs");
        System.out.println(user);
    }

    @Test
    public void findAllByUsername() {
        PageHelper.startPage(3, 1);
        List<User> users = userService.findAllByUsername("zs");
        System.out.println("users:" + users);

        PageInfo pageInfo = new PageInfo(users);
        System.out.println("pageInfo:"+pageInfo);
    }

    @Test
    public void findAllByDynamic() {
        User user = new User();
//        user.setId(12);
        user.setUsername("zs");
        user.setFullname("张三");
        user.setDeleted(false);

        List<User> users = userService.findAllByDynamic(user);
        System.out.println(users);
    }

    @Test
    public void findAllByIds() {
        userService.findAllByIds(Arrays.asList(1,2,3));
    }

    @Test
    public void addUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User(null, "ls", "456", "李四", "10010", true, false, null);
        User user2 = new User(null, "ww", "456", "王五", "10000", true, false, null);
        users.add(user1);
        users.add(user2);
        userService.addUsers(users);
    }
}