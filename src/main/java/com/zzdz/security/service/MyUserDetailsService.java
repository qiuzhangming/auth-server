package com.zzdz.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Classname MyUserDetailsService
 * @Description TODO
 * @Date 2019/11/4 11:40
 * @Created by joe
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = User.withUsername("zs").password("$2a$10$6unbZwvNaZwxWTxVpX.Jx.eP2TitsesC9euLpi2vv7Brps0MVYndq").authorities("p1").build();
        return userDetails;
    }
}
