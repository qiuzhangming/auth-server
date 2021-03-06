package com.zzdz.security.service;

import com.zzdz.security.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2019/11/4 14:50
 * @Created by joe
 */
public interface UserMapperService {

    boolean save(User user);

    boolean deleteById(@Param("id") Integer id);

    boolean updateById(User user);

    /*
        如果传入的参数有多个：
        1. 使用 #{param1} #{param2} 或者 0，1
        2. 使用 @Param("username")
        3. 传入pojo
        4. 传入一个map，map的key就是参数，value是值
     */
    User findByUsername(@Param("username") String username);

    List<User> findAllByUsername(@Param("username") String username);

    List<User> findAllByDynamic(User user);

    List<User> findAllByIds(@Param("ids") List<Integer> ids);

    void addUsers(@Param("users") List<User> users);
}
