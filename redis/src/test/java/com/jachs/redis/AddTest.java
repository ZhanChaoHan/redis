package com.jachs.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/***
 * 
 * @author zhanchaohan
 *
 */
public class AddTest {
	Jedis jedis = new RedisConfiger().init();

	/***
	 * 简单键值对存储
	 */
	@Test
	public void test() {
		// 存储数据到列表中
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
	}
	
}
