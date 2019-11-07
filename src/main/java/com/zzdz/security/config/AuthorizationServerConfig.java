package com.zzdz.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;


/**
 * @Classname AuthorizationServer
 * @Description 授权服务器配置
 * @Date 2019/10/31 14:24
 * @Created by joe
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Qualifier("myClientDetailsService")
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private TokenEnhancerChain tokenEnhancerChain;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean("myClientDetailsService")
    @Primary
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }


    /**
     * 配置客户端详情服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory() // 使用inMemory存储
//                .withClient("c1") // 客户端id
//                .secret(new BCryptPasswordEncoder().encode("secret")) // 客户端秘钥
//                .resourceIds("res1") // 可以访问的访问资源id
//                .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials","refresh_token") // 授权模式
//                .scopes("all") // 允许授权的范围
//                //.authorities("admin") // 客户端模式下的权限设置
//                .autoApprove(false) // false跳转到授权页面
//                .redirectUris("http://www.baidu.com");

        clients.withClientDetails(clientDetailsService);
    }


    /**
     * 配置令牌访问端点、令牌服务
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager) // 认证管理器，密码模式需要用到
                .authorizationCodeServices(authorizationCodeServices) // 授权码模式需要用到
                .tokenServices(tokenServices()) // 令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    /**
     * 配置令牌服务
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService); // 客户端详情服务
        services.setSupportRefreshToken(true); // 支持刷新令牌
        services.setTokenStore(tokenStore); // 令牌存储策略
        services.setTokenEnhancer(tokenEnhancerChain); // 设置令牌增强（jwt）

        services.setAccessTokenValiditySeconds(7200);// 令牌默认有效2小时
        services.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天
        return services;
    }

    /**
     *  授权码服务
     *  设置授权码模式的授权码如何存取，暂时才用内存
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
//        return new InMemoryAuthorizationCodeServices();

        return new JdbcAuthorizationCodeServices(dataSource);
    }


    /**
     * 配置访问端点的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();  // 表单认证
    }
}
