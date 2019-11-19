package com.zzdz.security.controller;

import com.zzdz.security.model.RelationalUserAuthority;
import com.zzdz.security.service.RelationalUserAuthorityMapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname RelationalUserAuthorityController
 * @Description 编辑用户对应的权限
 * @Date 2019/11/18 14:25
 * @Created by joe
 */
@Slf4j
@RestController
@RequestMapping("/userAuth")
@PreAuthorize("hasAnyAuthority('p1')")
public class RelationalUserAuthorityController {

    @Autowired
    RelationalUserAuthorityMapperService userAuthorityMapperService;

    @PostMapping("/")
    public RelationalUserAuthority save(@RequestBody RelationalUserAuthority userAuthority) {
        return userAuthorityMapperService.save(userAuthority);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return userAuthorityMapperService.deleteById(id);
    }

    @PutMapping("/")
    public boolean updateById(@RequestBody RelationalUserAuthority userAuthority) {
        return userAuthorityMapperService.updateById(userAuthority);
    }

    @GetMapping("/findByUserIdAndAuthorityId")
    public RelationalUserAuthority findByUserIdAndAuthorityId(@RequestParam("userId") Integer userId, @RequestParam("authorityId") Integer authorityId) {
        return userAuthorityMapperService.findByUserIdAndAuthorityId(userId, authorityId);
    }

    @GetMapping("/{id}")
    public List<RelationalUserAuthority> findByUserId(@PathVariable("id") Integer userId) {
        return userAuthorityMapperService.findByUserId(userId);
    }
}
