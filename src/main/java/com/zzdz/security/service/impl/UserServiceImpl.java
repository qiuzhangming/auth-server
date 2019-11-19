package com.zzdz.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzdz.security.mapper.UserMapper;
import com.zzdz.security.model.User;
import com.zzdz.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/11/4 13:50
 * @Created by joe
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User save(User user) {
        String encodePassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.save(user);
        return user;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public List<User> findAllByUsername(String username) {
        return userMapper.findAllByUsername(username);
    }

    @Override
    public List<User> findAllByDynamic(User user) {
        return userMapper.findAllByDynamic(user);
    }

    @Override
    public List<User> findAllByIds(List<Integer> ids) {
        return userMapper.findAllByIds(ids);
    }

    @Override
    public void addUsers(List<User> users) {
        userMapper.addUsers(users);
    }

    @Override
    public List<User> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.findAll();
        return users;
    }
}
