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

    /**
     * 删除用户建议使用updateById方法，更新数据库删除字段标志
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    boolean updateById(User user);

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

    /**
     * 动态拼装查询条件
     * 如果带了id，只根据id查询。
     * 如果没带id，动态组装查询条件。
     * @param user
     * @return
     */
    List<User> findAllByDynamic(User user);

    List<User> findAllByIds(List<Integer> ids);

    void addUsers(@Param("users") List<User> users);

    List<User> findAll(int pageNum, int pageSize);
}
