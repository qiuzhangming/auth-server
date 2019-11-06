package com.zzdz.security.service;

import com.zzdz.security.model.Authority;

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
}
