package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import ch.qos.logback.classic.Logger;

@EnableCaching
@SpringBootApplication

public class DataRedisExampleApplication {
	
	/*@Bean
    StringRedisTemplate redisTemplate() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setUsePool(true);
		StringRedisTemplate template= new StringRedisTemplate();
		template.setConnectionFactory(factory);
		return template;
	}*/
	
	@Bean
	RedisCacheManager cacheManager(StringRedisTemplate template) {
		return new RedisCacheManager(template);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DataRedisExampleApplication.class, args);
	}
	
	
}
