package com.zzdz.security.service;


import com.zzdz.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        UserDetails userDetails = org.springframework.security.core.userdetails.User
//                .withUsername("zs")
//                .password("$2a$10$6unbZwvNaZwxWTxVpX.Jx.eP2TitsesC9euLpi2vv7Brps0MVYndq")
//                .authorities("p1")
//                .build();

        // 根据用户名得到用户信息
        User user = userService.findByUsername(username);

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();

        return userDetails;
    }

}
