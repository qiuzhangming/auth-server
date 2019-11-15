package com.zzdz.security.controller;

import com.github.pagehelper.PageInfo;
import com.zzdz.security.model.User;
import com.zzdz.security.model.UserDto;
import com.zzdz.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2019/11/15 14:41
 * @Created by joe
 */
@Slf4j
@RestController
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('p1')")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody UserDto userDto) {
        log.info("添加用户:{}", userDto);

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setDeleted(false);

        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Boolean deteteUser(@PathVariable("id") Integer id) {
        log.info("删除用户：{}" +id);

        User user = new User()
                .setId(id)
                .setDeleted(true)
                ;
        return userService.updateById(user);
    }

    @PutMapping("/")
    public Boolean updateUser(User user) {
        log.info("修改用户用户：{}" +user);

        return userService.updateById(user);
    }

    @GetMapping("/{id}")
    public List<User> findById(@PathVariable("id") Integer id) {
        log.info("修改用户用户：{}" + id);
        User user = new User().setId(id);
        return userService.findAllByDynamic(user);
    }


    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        log.info("查询所有用户。");
        List<User> users = userService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(users);

        return pageInfo;
    }
}
