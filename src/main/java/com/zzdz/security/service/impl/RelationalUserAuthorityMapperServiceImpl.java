package com.zzdz.security.service.impl;

import com.zzdz.security.mapper.RelationalUserAuthorityMapper;
import com.zzdz.security.model.RelationalUserAuthority;
import com.zzdz.security.service.RelationalUserAuthorityMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RelationalUserAuthorityMapperServiceImpl
 * @Description TODO
 * @Date 2019/11/6 17:03
 * @Created by joe
 */
@Service
public class RelationalUserAuthorityMapperServiceImpl implements RelationalUserAuthorityMapperService {

    @Autowired
    RelationalUserAuthorityMapper userAuthorityMapper;

    @Override
    public RelationalUserAuthority save(RelationalUserAuthority userAuthority) {
        userAuthorityMapper.save(userAuthority);
        return userAuthority;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userAuthorityMapper.deleteById(id);
    }

    @Override
    public boolean updateById(RelationalUserAuthority userAuthority) {
        return userAuthorityMapper.updateById(userAuthority);
    }

    @Override
    public RelationalUserAuthority findByUserIdAndAuthorityId(Integer userId, Integer authorityId) {
        return userAuthorityMapper.findByUserIdAndAuthorityId(userId, authorityId);
    }

    @Override
    public List<RelationalUserAuthority> findByUserId(Integer userId) {
        return userAuthorityMapper.findByUserId(userId);
    }
}
