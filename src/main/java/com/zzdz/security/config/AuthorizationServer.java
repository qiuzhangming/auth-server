package com.zzdz.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Classname AuthorizationServer
 * @Description 授权服务器配置
 * @Date 2019/10/31 14:24
 * @Created by joe
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;


    /**
     * 配置客户端详情服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用inMemory存储
                .withClient("c1") // 客户端id
                .secret(new BCryptPasswordEncoder().encode("secret")) // 客户端秘钥
                .resourceIds("res1") // 可以访问的访问资源id
                .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials","refresh_token") // 授权模式
                .scopes("all") // 允许授权的范围
                .autoApprove(false) // false跳转到授权页面
                .redirectUris("http://www.baidu.com");
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
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        services.setAccessTokenValiditySeconds(7200);// 令牌默认有效2小时
        services.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天
        return services;
    }

    /**
     *  授权码服务
     *  设置授权码模式的授权码如何存取，暂时才用内存
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
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
