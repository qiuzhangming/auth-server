package com.zzdz.security.service;

import com.zzdz.security.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/11/4 13:31
 * @Created by joe
 */
public interface UserService {

    User save(User user);

    boolean deleteById(Integer id);

    boolean updateById(User user);

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

    List<User> findAllByDynamic(User user);

    List<User> findAllByIds(List<Integer> ids);

    void addUsers(@Param("users") List<User> users);
}
