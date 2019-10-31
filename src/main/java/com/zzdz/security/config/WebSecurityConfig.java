package com.zzdz.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Classname WebSecurityConfig
 * @Description TODO
 * @Date 2019/10/31 15:08
 * @Created by joe
 */
@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 密码授权模式需要用
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zs").password("$2a$10$6unbZwvNaZwxWTxVpX.Jx.eP2TitsesC9euLpi2vv7Brps0MVYndq").authorities("p1").build());
        manager.createUser(User.withUsername("ls").password("$2a$10$eaiuwqSxaQfElELY0a67dOXCmXySY9oODEcUNbi0vVhD0P4vDvKA6").authorities("p2").build());
        return manager;
    }


    /**
     * 认证管理器-密码授权模式需要用
     * 这里如果方法名使用authenticationManager会有问题
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager1() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance(); //使用明文
    }

    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/r/r1").hasAnyAuthority("p1")
                .antMatchers("/hello").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                //允许表单登录
                .formLogin()
                // 自定义登录成功页面
//                .successForwardUrl("/login-success")
        ;
    }
}
