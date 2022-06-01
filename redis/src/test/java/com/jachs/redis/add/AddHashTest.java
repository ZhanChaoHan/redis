package com.jachs.redis.add;

import org.junit.Test;
import com.jachs.redis.RedisConfiger;
import redis.clients.jedis.Jedis;

/***
	Redis hash 是一个 string 类型的 field（字段） 和 value（值） 的映射表，hash 特别适合用于存储对象。<br>
	Redis 中每个 hash 可以存储 232 - 1 键值对（40多亿）。<br>
	hash类型可以理解为map集合，{key1:value1,key2:value2}<br>
	@author zhanchaohan
 */
public class AddHashTest {
	Jedis jedis = new RedisConfiger().init();

	private static final String KEY="hash-Key";
	
	@Test
	public void test1() {
		
	}
}
