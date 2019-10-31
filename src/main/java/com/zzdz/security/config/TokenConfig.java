package com.zzdz.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Classname TokenConfig
 * @Description 配置令牌服务
 * @Date 2019/10/31 14:44
 * @Created by joe
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore() {
        // 使用内存存储令牌（普通令牌）
        return new InMemoryTokenStore();
    }
}
