package com.itfan.kernel.config;

import com.itfan.crawler.redis.RedisManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.mapping.RedisMappingContext;

/**
 * @author: ralap
 * @date: created at 2018/1/13 15:20
 */
@Configuration
@AllArgsConstructor
public class RedisConfig {

    private final StringRedisTemplate stringRedisTemplate;

    @Bean
    public RedisManager redisManager(){
        return new RedisManager(stringRedisTemplate);
    }
}
