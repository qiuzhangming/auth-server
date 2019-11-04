package com.zzdz.security.dao;

import com.zzdz.security.model.User;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2019/11/4 13:31
 * @Created by joe
 */
public interface UserDao {

    User save(User user);

    boolean deleteById(Integer id);

    boolean updateUser(User user);

    User findByUsername(String username);
}
