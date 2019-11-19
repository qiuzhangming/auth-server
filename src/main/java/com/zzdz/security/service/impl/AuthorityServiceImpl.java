package com.zzdz.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzdz.security.mapper.AuthorityMapper;
import com.zzdz.security.model.Authority;
import com.zzdz.security.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Authority> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Authority> authorities = authorityMapper.findAll();
        return authorities;
    }
}
