package com.zzdz.security.service;

import com.zzdz.security.mapper.AuthorityMapper;
import com.zzdz.security.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname AuthorityServiceImpl
 * @Description TODO
 * @Date 2019/11/6 16:28
 * @Created by joe
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    @Override
    public Authority save(Authority authority) {
        authorityMapper.save(authority);
        return authority;
    }

    @Override
    public boolean deleteById(Integer id) {
        return authorityMapper.deleteById(id);
    }

    @Override
    public boolean updateById(Authority authority) {
        return authorityMapper.updateById(authority);
    }

    @Override
    public Authority findById(Integer id) {
        return authorityMapper.findById(id);
    }
}
