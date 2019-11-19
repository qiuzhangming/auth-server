package com.zzdz.security.mapper;

import com.zzdz.security.model.OauthClientDetails;

import java.util.List;

public interface OauthClientDetailsMapper {

    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    OauthClientDetails selectByPrimaryKey(String clientId);

    List<OauthClientDetails> selectAll();

    int updateByPrimaryKey(OauthClientDetails record);
}