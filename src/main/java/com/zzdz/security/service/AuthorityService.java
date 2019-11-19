package com.zzdz.security.service;

import com.zzdz.security.model.Authority;

import java.util.List;

/**
 * @Classname AuthorityService
 * @Description TODO
 * @Date 2019/11/6 16:25
 * @Created by joe
 */
public interface AuthorityService {

    Authority save(Authority authority);

    boolean deleteById(Integer id);

    boolean updateById(Authority authority);

    Authority findById(Integer id);

    List<Authority> findAll(int pageNum, int pageSize);
}
