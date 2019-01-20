package com.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {
	private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);
	@Value("${redis.ip}")
	private String ip;
	@Value("${redis.port}")
	private Integer port;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		log.info(String.format("Datos de conexion; IP: %s, PORT: %s", ip, port));
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(ip);
		factory.setPort(port);
		return factory;
	}
 
	@Bean("redisTemplate")
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}
}
