package com.practice.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedisApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	void redisConnectionTest() {
		final String key = "ab";
		final String data = "1";

		final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, data);

		final String result = valueOperations.get(key);
		System.out.println(valueOperations.get(key));
		assertEquals(data, result);
	}
}
