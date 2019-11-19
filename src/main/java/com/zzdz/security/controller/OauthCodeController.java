package com.zzdz.security.controller;

import com.zzdz.security.mapper.OauthCodeMapper;
import com.zzdz.security.model.OauthCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname OauthCodeController
 * @Description TODO
 * @Date 2019/11/19 9:36
 * @Created by joe
 */
@Slf4j
@RestController
@RequestMapping("/authCode")
@PreAuthorize("hasAnyAuthority('p1')")
public class OauthCodeController {

    @Autowired
    OauthCodeMapper oauthCodeMapper;

    @GetMapping("/findAll")
    List<OauthCode> selectAll() {
        return oauthCodeMapper.selectAll();
    }
}
