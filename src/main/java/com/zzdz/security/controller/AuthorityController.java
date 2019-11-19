package com.zzdz.security.controller;

import com.github.pagehelper.PageInfo;
import com.zzdz.security.model.Authority;
import com.zzdz.security.service.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname AuthorityController
 * @Description 权限编辑
 * @Date 2019/11/18 13:23
 * @Created by joe
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@PreAuthorize("hasAnyAuthority('p1')")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @PostMapping("/")
    public Authority save(@RequestBody Authority authority) {
        return authorityService.save(authority);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return authorityService.deleteById(id);
    }

    @PutMapping("/")
    public boolean updateById(@RequestBody Authority authority) {
        return authorityService.updateById(authority);
    }

    @GetMapping("/{id}")
    public Authority findById(@PathVariable("id") Integer id) {
        return authorityService.findById(id);
    }

    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        List<Authority> authorities = authorityService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(authorities);

        return pageInfo;
    }
}
