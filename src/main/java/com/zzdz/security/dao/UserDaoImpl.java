package com.zzdz.security.dao;

import com.zzdz.security.mapper.UserMapper;
import com.zzdz.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2019/11/4 13:50
 * @Created by joe
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
