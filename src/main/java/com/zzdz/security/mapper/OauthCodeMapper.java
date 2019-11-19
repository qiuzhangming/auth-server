package com.zzdz.security.mapper;


import com.zzdz.security.model.OauthCode;

import java.util.List;

public interface OauthCodeMapper {

    int insert(OauthCode record);

    List<OauthCode> selectAll();
}