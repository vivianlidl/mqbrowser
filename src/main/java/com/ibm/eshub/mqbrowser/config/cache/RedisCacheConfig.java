package com.ibm.eshub.mqbrowser.config.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.database}")
	private int database;

	// @Value("${spring.redis.password}")
	// private String password;
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();// redisSentinelConfiguration()
		factory.setHostName(host);
		factory.setPort(port);
		factory.setTimeout(timeout);
		// factory.setPassword(password);
		factory.setDatabase(database);
		return factory;
	}

	/*@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
	}

	*//**
	 * 设置RedisCacheManager 使用cache注解管理redis缓存
	 *
	 * @return
	 *//*
	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
		return redisCacheManager;
	}

	*//**
	 * 配置RedisTemplate 设置添加序列化器 key 使用string序列化器 value 使用Json序列化器
	 * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
	 *
	 * @return
	 *//*
	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		// StringRedisTemplate的构造方法中默认设置了stringSerializer
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		// 设置开启事务
		template.setEnableTransactionSupport(true);
		// set key serializer
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// set value serializer
		// template.setDefaultSerializer(jackson2JsonRedisSerializer);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		template.setConnectionFactory(jedisConnectionFactory());
		template.afterPropertiesSet();
		return template;
	}

	*//**
	 * 自定义生成redis-key
	 *
	 * @return
	 *//*
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName()).append(".");
				sb.append(method.getName()).append(".");
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				System.out.println("keyGenerator=" + sb.toString());
				return sb.toString();
			}
		};
	}*/

	
	 
 
    
    @Bean 
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //set expire time
        cacheManager.setDefaultExpiration(10000);
        return cacheManager;
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate(jedisConnectionFactory());
        setSerializer(template);//set serializer tool
        template.afterPropertiesSet();
        return template;
    }
     private void setSerializer(StringRedisTemplate template){
            @SuppressWarnings({ "rawtypes", "unchecked" })
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
     }

}