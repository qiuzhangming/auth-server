package com.zzdz.security.service;

import com.zzdz.security.model.Authority;
import com.zzdz.security.model.RelationalUserAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MyUserDetailsService
 * @Description TODO
 * @Date 2019/11/4 11:40
 * @Created by joe
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    RelationalUserAuthorityMapperService userAuthorityMapperService;

    @Autowired
    AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1.根据用户名得到用户id
        com.zzdz.security.model.User user = userService.findByUsername(username);

        // 2.根据用户id从关系表中拿到权限id
        List<RelationalUserAuthority> relationalUserAuthorities = userAuthorityMapperService.findByUserId(user.getId());

        // 3.根据权限id从权限表中拿到权限
        List<String> authorities = new ArrayList<>();
        for (RelationalUserAuthority relationalUserAuthority : relationalUserAuthorities) {
            Authority authority = authorityService.findById(relationalUserAuthority.getAuthorityId());
            authorities.add(authority.getAuthorityName());
        }
        //UserDetails userDetails = User.withUsername("zs").password("$2a$10$6unbZwvNaZwxWTxVpX.Jx.eP2TitsesC9euLpi2vv7Brps0MVYndq").authorities("p1").build();
        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities.toString())
                .build();
        return userDetails;
    }
}
