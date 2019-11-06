package com.zzdz.security.mapper;

import com.zzdz.security.model.RelationalUserAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname RelationalUserAuthorityMapper
 * @Description TODO
 * @Date 2019/11/6 16:49
 * @Created by joe
 */
public interface RelationalUserAuthorityMapper {

    boolean save(RelationalUserAuthority userAuthority);

    boolean deleteById(@Param("id") Integer id);

    boolean updateById(RelationalUserAuthority userAuthority);

    RelationalUserAuthority findByUserIdAndAuthorityId(@Param("userId") Integer userId, @Param("authorityId") Integer authorityId);

    List<RelationalUserAuthority> findByUserId(@Param("userId") Integer userId);
}
