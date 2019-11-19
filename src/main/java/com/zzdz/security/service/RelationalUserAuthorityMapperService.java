package com.zzdz.security.service;

import com.zzdz.security.model.RelationalUserAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname RelationalUserAuthorityMapper
 * @Description TODO
 * @Date 2019/11/6 16:49
 * @Created by joe
 */
public interface RelationalUserAuthorityMapperService {

    RelationalUserAuthority save(RelationalUserAuthority userAuthority);

    boolean deleteById(Integer id);

    boolean updateById(RelationalUserAuthority userAuthority);

    RelationalUserAuthority findByUserIdAndAuthorityId(Integer userId, Integer authorityId);

    List<RelationalUserAuthority> findByUserId(Integer userId);
}
