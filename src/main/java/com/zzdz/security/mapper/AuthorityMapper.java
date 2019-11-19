package com.zzdz.security.mapper;

import com.zzdz.security.model.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Classname AuthorityMapper
 * @Description TODO
 * @Date 2019/11/6 12:19
 * @Created by joe
 */
public interface AuthorityMapper {

    boolean save(Authority user);

    boolean deleteById(@Param("id") Integer id);

    boolean updateById(Authority authority);

    Authority findById(@Param("id") Integer id);

    List<Authority> findAll();

}
