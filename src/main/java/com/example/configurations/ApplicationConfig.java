package com.example.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {


    @Bean
    @LoadBalanced
    public RestTemplate createLoadBalancedRestTemplateBean(){
        return new RestTemplate();
    }


    @Bean
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }
//    @Bean
//    public BCryptPasswordEncoder createBCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
