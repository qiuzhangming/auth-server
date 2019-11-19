package com.zzdz.security.controller;

import com.zzdz.security.mapper.OauthClientDetailsMapper;
import com.zzdz.security.model.OauthClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname OauthClientDetailsController
 * @Description TODO
 * @Date 2019/11/18 16:58
 * @Created by joe
 */
@Slf4j
@RestController
@RequestMapping("/authClient")
@PreAuthorize("hasAnyAuthority('p1')")
public class OauthClientDetailsController {

    @Autowired
    OauthClientDetailsMapper oauthClientDetailsMapper;

    @PostMapping("/")
    int insert(@RequestBody OauthClientDetails record) {

        String encodePassword = new BCryptPasswordEncoder().encode(record.getClientSecret());
        record.setClientSecret(encodePassword);

        return oauthClientDetailsMapper.insert(record);
    }

    @DeleteMapping("/{clientId}")
    int deleteByPrimaryKey(@PathVariable("clientId") String clientId) {
        return oauthClientDetailsMapper.deleteByPrimaryKey(clientId);
    }

    @PutMapping("/")
    int updateByPrimaryKey(@RequestBody OauthClientDetails record) {
        return oauthClientDetailsMapper.updateByPrimaryKey(record);
    }

    @GetMapping("/{clientId}")
    OauthClientDetails selectByPrimaryKey(@PathVariable("clientId") String clientId) {
        return oauthClientDetailsMapper.selectByPrimaryKey(clientId);
    }

    @GetMapping("/findAll")
    List<OauthClientDetails> selectAll() {
        return oauthClientDetailsMapper.selectAll();
    }


}
